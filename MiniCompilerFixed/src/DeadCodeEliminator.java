import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeadCodeEliminator {

    public void eliminate(List<String> tacLines) {

        if (tacLines == null || tacLines.isEmpty()) {
            System.out.println("No TAC to analyse.");
            return;
        }

        // ======================================================
        // PASS 1 — COPY PROPAGATION
        // If we see:
        //     t1 = a + b
        //     c  = t1
        // Replace the second line's RHS with the full RHS of t1:
        //     c  = a + b
        // Then mark t1 as a propagated temp (will be removed later)
        // ======================================================
        Map<String, String> tempDef = new HashMap<>(); // temp -> its full RHS expression
        List<String> afterProp = new ArrayList<>();
        Set<String> propagated = new HashSet<>();

        for (String line : tacLines) {

            String trimmed = line.trim();

            if (trimmed.startsWith("print ")) {
                // substitute any temp used in print
                String arg = trimmed.substring(6).trim();
                if (tempDef.containsKey(arg)) {
                    afterProp.add("print " + tempDef.get(arg));
                    propagated.add(arg);
                } else {
                    afterProp.add(line);
                }
                continue;
            }

            int eq = trimmed.indexOf('=');
            if (eq < 0) { afterProp.add(line); continue; }

            String lhs = trimmed.substring(0, eq).trim();
            String rhs = trimmed.substring(eq + 1).trim();

            // if RHS is a single temp we already know -> substitute
            if (tempDef.containsKey(rhs)) {
                String expanded = tempDef.get(rhs);
                propagated.add(rhs);
                afterProp.add(lhs + " = " + expanded);
                // record this definition too (in case it gets propagated further)
                if (lhs.startsWith("t") && lhs.matches("t\\d+")) {
                    tempDef.put(lhs, expanded);
                }
            } else {
                afterProp.add(line);
                // record temp definitions for future propagation
                if (lhs.startsWith("t") && lhs.matches("t\\d+")) {
                    tempDef.put(lhs, rhs);
                }
            }
        }

        // ======================================================
        // PASS 2 — DEAD CODE ELIMINATION
        // Collect every variable that appears on any RHS / print
        // ======================================================
        Set<String> usedVars = new HashSet<>();

        for (String line : afterProp) {
            String trimmed = line.trim();

            if (trimmed.startsWith("print ")) {
                String arg = trimmed.substring(6).trim();
                if (isIdentifier(arg)) usedVars.add(arg);
                // also mark tokens inside a propagated expression
                for (String tok : arg.split("[\\s+\\-*/()]+")) {
                    if (isIdentifier(tok.trim())) usedVars.add(tok.trim());
                }
                continue;
            }

            int eq = trimmed.indexOf('=');
            if (eq < 0) continue;

            String rhs = trimmed.substring(eq + 1).trim();
            for (String tok : rhs.split("[\\s+\\-*/()]+")) {
                if (isIdentifier(tok.trim())) usedVars.add(tok.trim());
            }
        }

        // ======================================================
        // PASS 3 — FILTER: remove lines whose LHS is never used
        //          AND remove propagated temps (their definition
        //          has been inlined into the user's variable)
        // ======================================================
        List<String> liveCode = new ArrayList<>();
        List<String> deadCode = new ArrayList<>();

        for (String line : afterProp) {
            String trimmed = line.trim();

            if (trimmed.startsWith("print ")) {
                liveCode.add(trimmed);
                continue;
            }

            int eq = trimmed.indexOf('=');
            if (eq < 0) { liveCode.add(trimmed); continue; }

            String lhs = trimmed.substring(0, eq).trim();

            boolean isPropagedTemp = propagated.contains(lhs)
                    && lhs.startsWith("t") && lhs.matches("t\\d+");
            boolean isUnused = !usedVars.contains(lhs)
                    && !(lhs.startsWith("t") && lhs.matches("t\\d+"));

            if (isPropagedTemp || isUnused) {
                deadCode.add(trimmed);
            } else {
                liveCode.add(trimmed);
            }
        }

        // ======================================================
        // OUTPUT
        // ======================================================
        if (deadCode.isEmpty()) {
            System.out.println(
                ConsoleColors.GREEN +
                "No dead code found." +
                ConsoleColors.RESET
            );
        } else {
            System.out.println(
                ConsoleColors.RED +
                "Instructions removed after optimisation:" +
                ConsoleColors.RESET
            );
            for (String d : deadCode) {
                System.out.println(
                    ConsoleColors.RED + "  [-] " + d + ConsoleColors.RESET
                );
            }
        }

        System.out.println(
            ConsoleColors.GREEN +
            "\nOptimised TAC:" +
            ConsoleColors.RESET
        );
        for (String l : liveCode) {
            System.out.println("  " + l);
        }
    }

    private boolean isIdentifier(String token) {
        if (token == null || token.isEmpty()) return false;
        return token.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }
}
