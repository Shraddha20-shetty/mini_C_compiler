import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;
import java.util.List;

public class SemanticAnalyzer {

    private SymbolTable symbolTable = new SymbolTable();
    private int errorCount = 0;
    private List<String> errors   = new ArrayList<>();
    private List<String> warnings = new ArrayList<>();

    public void analyze(ParseTree tree) {
        traverse(tree);

        for (String w : warnings)
            System.out.println(ConsoleColors.YELLOW + "[Warning] " + w + ConsoleColors.RESET);
        for (String e : errors)
            System.out.println(ConsoleColors.RED    + "[Error]   " + e + ConsoleColors.RESET);

        if (errorCount == 0 && warnings.isEmpty())
            System.out.println(ConsoleColors.GREEN + "No semantic errors found." + ConsoleColors.RESET);
        else
            System.out.println(ConsoleColors.RED + "\nTotal Semantic Errors : " + errorCount + ConsoleColors.RESET);

        System.out.println(ConsoleColors.CYAN + "\n===== SEMANTIC ANALYSIS (JSON) =====\n" + ConsoleColors.RESET);
        printSemanticJson();
    }

    private void traverse(ParseTree node) {
        if (node == null) return;

        // ---- DECLARATION ----
        if (node instanceof MiniCParser.DeclarationContext) {
            String type    = node.getChild(0).getText();
            String varName = node.getChild(1).getText();
            if (symbolTable.contains(varName))
                addError("Variable already declared: '" + varName + "'");
            else
                symbolTable.addSymbol(varName, type, "local");

            if (node.getChildCount() == 5) {
                String val = getLeafValue(node.getChild(3));
                checkTypeMatch(type, varName, val);
            }
            return;
        }

        // ---- ARRAY DECLARATION ----
        if (node instanceof MiniCParser.ArrayDeclarationContext) {
            String type    = node.getChild(0).getText();
            String varName = node.getChild(1).getText();
            String size    = node.getChild(3).getText();
            if (symbolTable.contains(varName))
                addError("Array already declared: '" + varName + "'");
            else
                symbolTable.addSymbol(varName, type + "[" + size + "]", "local");
            return;
        }

        // ---- ASSIGNMENT ----
        if (node instanceof MiniCParser.AssignmentContext) {
            String varName = node.getChild(0).getText();
            if (!symbolTable.contains(varName))
                addError("Undeclared variable used: '" + varName + "'");
            else {
                String val  = getLeafValue(node.getChild(2));
                String type = symbolTable.getType(varName).replaceAll("\\[.*\\]", "");
                checkTypeMatch(type, varName, val);
            }
            return;
        }

        // ---- ARRAY ASSIGNMENT ----
        if (node instanceof MiniCParser.ArrayAssignmentContext) {
            String varName = node.getChild(0).getText();
            if (!symbolTable.contains(varName))
                addError("Undeclared array used: '" + varName + "'");
            return;
        }

        // ---- PRINT ----
        if (node instanceof MiniCParser.PrintStatementContext) {
            String val = getLeafValue(node.getChild(2));
            if (isIdentifier(val) && !symbolTable.contains(val))
                addError("Undeclared variable in print: '" + val + "'");
            return;
        }

        for (int i = 0; i < node.getChildCount(); i++)
            traverse(node.getChild(i));
    }

    private void checkTypeMatch(String declaredType, String varName, String value) {
        if (value == null || value.isEmpty()) return;
        boolean isFloat = value.contains(".");
        if (declaredType.equals("int") && isFloat)
            addError("Type mismatch: cannot assign float value '" + value
                    + "' to int variable '" + varName + "'");
        else if (declaredType.equals("float") && !isFloat && isNumeric(value))
            warnings.add("Implicit int-to-float: assigning '" + value
                    + "' to float variable '" + varName + "'");
    }

    private String getLeafValue(ParseTree node) {
        if (node == null) return "";
        if (node instanceof TerminalNode) return node.getText();
        if (node.getChildCount() == 1) return getLeafValue(node.getChild(0));
        return node.getText();
    }

    private void addError(String msg) { errors.add(msg); errorCount++; }
    private boolean isIdentifier(String s) { return s != null && s.matches("[a-zA-Z_][a-zA-Z0-9_]*"); }
    private boolean isNumeric(String s) {
        try { Double.parseDouble(s); return true; } catch (NumberFormatException e) { return false; }
    }

    private void printSemanticJson() {
        System.out.println("{");
        System.out.println("  \"semanticAnalysis\": {");
        System.out.println("    \"status\": \"" + (errorCount == 0 ? "SUCCESS" : "FAILED") + "\",");
        System.out.println("    \"errorCount\": " + errorCount + ",");
        System.out.println("    \"errors\": [");
        for (int i = 0; i < errors.size(); i++)
            System.out.println("      \"" + errors.get(i) + "\"" + (i < errors.size()-1 ? "," : ""));
        System.out.println("    ],");
        System.out.println("    \"symbolTable\": [");
        symbolTable.printAsJsonEntries();
        System.out.println("    ]");
        System.out.println("  }");
        System.out.println("}");
    }

    public void printSymbolTable() { symbolTable.printTable(); }
}
