import java.util.ArrayList;
import java.util.List;

public class TACGenerator {

    private int tempCount  = 1;
    private int labelCount = 1;
    private List<String> tac = new ArrayList<>();

    public void generate(ASTNode root) {
        traverse(root);

        if (tac.isEmpty()) { System.out.println("No TAC generated"); return; }

        // ---- plain text ----
        for (String line : tac) System.out.println(line);

        // ---- JSON ----
        System.out.println(
            ConsoleColors.CYAN +
            "\n===== INTERMEDIATE CODE (TAC) — JSON =====\n" +
            ConsoleColors.RESET
        );
        System.out.println("{");
        System.out.println("  \"TAC\": [");
        for (int i = 0; i < tac.size(); i++) {
            String line = tac.get(i).trim();
            System.out.print("    { \"instruction\": \"" + escape(line) + "\" }");
            System.out.println(i < tac.size() - 1 ? "," : "");
        }
        System.out.println("  ]");
        System.out.println("}");
    }

    public List<String> getTac() { return tac; }

    private String escape(String s) { return s.replace("\\", "\\\\").replace("\"", "\\\""); }

    private String traverse(ASTNode node) {
        if (node == null) return "";
        switch (node.value) {
            case "Program":
                for (ASTNode c : node.children) traverse(c); return "";
            case "DECL":
                if (node.children.size() == 3) {
                    String v = node.children.get(1).value;
                    String r = traverse(node.children.get(2));
                    tac.add(v + " = " + r); return v;
                }
                return node.children.size() >= 2 ? node.children.get(1).value : "";
            case "ARRAY_DECL":
                tac.add("alloc " + node.children.get(1).value + "[" + node.children.get(2).value + "]");
                return "";
            case "=":
                String l = node.children.get(0).value, r = traverse(node.children.get(1));
                tac.add(l + " = " + r); return l;
            case "ARRAY_ASSIGN": {
                String name = node.children.get(0).value, idx = traverse(node.children.get(1)), val = traverse(node.children.get(2));
                tac.add(name + "[" + idx + "] = " + val); return "";
            }
            case "PRINT":
                String arg = node.children.isEmpty() ? "" : traverse(node.children.get(0));
                tac.add("print " + arg); return "";
            case "IF": {
                String lt = "L" + labelCount++, lf = "L" + labelCount++, le = "L" + labelCount++;
                ASTNode cond = node.children.get(0);
                String lhs = traverse(cond.children.get(0)), op = cond.children.get(1).value, rhs = traverse(cond.children.get(2));
                tac.add("if " + lhs + " " + op + " " + rhs + " goto " + lt);
                tac.add("goto " + lf); tac.add(lt + ":");
                for (ASTNode s : node.children.get(1).children) traverse(s);
                tac.add("goto " + le); tac.add(lf + ":");
                if (node.children.size() == 3) for (ASTNode s : node.children.get(2).children) traverse(s);
                tac.add(le + ":"); return "";
            }
            case "WHILE": {
                String ls = "L" + labelCount++, lb = "L" + labelCount++, le = "L" + labelCount++;
                tac.add(ls + ":"); ASTNode cond = node.children.get(0);
                String lhs = traverse(cond.children.get(0)), op = cond.children.get(1).value, rhs = traverse(cond.children.get(2));
                tac.add("if " + lhs + " " + op + " " + rhs + " goto " + lb);
                tac.add("goto " + le); tac.add(lb + ":");
                for (ASTNode s : node.children.get(1).children) traverse(s);
                tac.add("goto " + ls); tac.add(le + ":"); return "";
            }
            case "EMPTY": return "";  // empty forInit or forUpdate
            case "FOR": {
                traverse(node.children.get(0));
                String ls = "L" + labelCount++, lb = "L" + labelCount++, le = "L" + labelCount++;
                tac.add(ls + ":"); ASTNode cond = node.children.get(1);
                String lhs = traverse(cond.children.get(0)), op = cond.children.get(1).value, rhs = traverse(cond.children.get(2));
                tac.add("if " + lhs + " " + op + " " + rhs + " goto " + lb);
                tac.add("goto " + le); tac.add(lb + ":");
                for (ASTNode s : node.children.get(3).children) traverse(s);
                traverse(node.children.get(2)); tac.add("goto " + ls); tac.add(le + ":"); return "";
            }
            case "ARRAY_ACCESS": {
                String name = node.children.get(0).value, idx = traverse(node.children.get(1)), t = "t" + tempCount++;
                tac.add(t + " = " + name + "[" + idx + "]"); return t;
            }
            case "+": case "-": case "*": case "/": {
                String lhs = traverse(node.children.get(0)), rhs = traverse(node.children.get(1)), t = "t" + tempCount++;
                tac.add(t + " = " + lhs + " " + node.value + " " + rhs); return t;
            }
            default: return node.value;
        }
    }
}
