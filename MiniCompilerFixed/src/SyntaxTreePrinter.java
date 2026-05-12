import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SyntaxTreePrinter {

    // ======================================
    // ENTRY POINT
    // ======================================
    public void print(ParseTree tree) {

        System.out.println(
                ConsoleColors.BLUE +
                "\n===== SYNTAX ANALYSIS (TREE) =====\n" +
                ConsoleColors.RESET
        );

        traverseTree(tree, "", true);

        System.out.println(
                ConsoleColors.CYAN +
                "\n===== SYNTAX ANALYSIS (JSON) =====\n" +
                ConsoleColors.RESET
        );

        System.out.println(toJson(tree));
    }

    // ======================================
    // TREE PRINT
    // ======================================
    private void traverseTree(ParseTree node, String indent, boolean last) {

        if (node == null) return;

        // skip EOF terminal silently
        if (node instanceof TerminalNode
                && node.getText().equals("<EOF>")) return;

        System.out.print(indent);
        System.out.print(last ? "└── " : "├── ");
        String nextIndent = indent + (last ? "    " : "│   ");

        if (node instanceof TerminalNode) {
            System.out.println(node.getText());
            return;
        }

        String name = simpleName(node);
        System.out.println(name);

        // count non-EOF children
        int total = 0;
        for (int i = 0; i < node.getChildCount(); i++) {
            ParseTree child = node.getChild(i);
            if (!(child instanceof TerminalNode
                    && child.getText().equals("<EOF>"))) total++;
        }

        int seen = 0;
        for (int i = 0; i < node.getChildCount(); i++) {
            ParseTree child = node.getChild(i);
            if (child instanceof TerminalNode
                    && child.getText().equals("<EOF>")) continue;
            seen++;
            traverseTree(child, nextIndent, seen == total);
        }
    }

    // ======================================
    // JSON ENTRY
    // ======================================
    private String toJson(ParseTree node) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"syntaxAnalysis\": ");
        buildJson(node, sb, 1);
        sb.append("\n}");
        return sb.toString();
    }

    // ======================================
    // JSON BUILDER  (fixed — no dangling { )
    // ======================================
    private void buildJson(ParseTree node, StringBuilder sb, int level) {

        if (node == null) return;

        String pad  = "  ".repeat(level);
        String pad2 = "  ".repeat(level + 1);

        // TERMINAL
        if (node instanceof TerminalNode) {
            String text = node.getText();
            if (text.equals("<EOF>")) {
                // emit nothing — caller must not add a comma for this node
                return;
            }
            sb.append("{\n");
            sb.append(pad2).append("\"type\": \"Terminal\",\n");
            sb.append(pad2).append("\"value\": \"")
              .append(escape(text)).append("\"\n");
            sb.append(pad).append("}");
            return;
        }

        // NON-TERMINAL
        sb.append("{\n");
        sb.append(pad2).append("\"node\": \"").append(simpleName(node)).append("\",\n");
        sb.append(pad2).append("\"children\": [\n");

        // collect children that are not EOF
        int total = node.getChildCount();
        int emitted = 0;

        for (int i = 0; i < total; i++) {

            ParseTree child = node.getChild(i);

            // skip EOF terminals entirely
            if (child instanceof TerminalNode
                    && child.getText().equals("<EOF>")) continue;

            if (emitted > 0) sb.append(",\n");

            sb.append(pad2).append("  ");
            buildJson(child, sb, level + 2);
            emitted++;
        }

        sb.append("\n").append(pad2).append("]\n");
        sb.append(pad).append("}");
    }

    // ======================================
    // HELPERS
    // ======================================
    private String simpleName(ParseTree node) {
        return node.getClass()
                .getSimpleName()
                .replace("Context", "")
                .replace("MiniCParser$", "");
    }

    private String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
