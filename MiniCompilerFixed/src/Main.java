import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // =====================================================
        // INPUT FILE
        // =====================================================
        // =====================================================
        // PRINT INPUT SOURCE FILE
        // =====================================================
        System.out.println(
                ConsoleColors.YELLOW +
                "\n===== INPUT SOURCE FILE (test.mc) =====\n" +
                ConsoleColors.RESET
        );

        java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.FileReader("input/test.mc"));
        String fileLine;
        int lineNo = 1;
        while ((fileLine = reader.readLine()) != null) {
            System.out.printf("  %2d │ %s%n", lineNo++, fileLine);
        }
        reader.close();
        System.out.println();

        CharStream input =
                CharStreams.fromFileName("input/test.mc");

        // =====================================================
        // LEXER
        // =====================================================
        MiniCLexer lexer = new MiniCLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        // =====================================================
        // LEXICAL ANALYSIS
        // =====================================================
        System.out.println(
                ConsoleColors.CYAN +
                "\n===== LEXICAL ANALYSIS =====\n" +
                ConsoleColors.RESET
        );

        System.out.println("[");
        boolean first = true;

        for (Token token : tokens.getTokens()) {

            String name = MiniCLexer.VOCABULARY
                            .getSymbolicName(token.getType());

            if (name != null && token.getType() != Token.EOF) {

                if (!first) System.out.println(",");

                System.out.println("  {");
                System.out.println("    \"tokenType\": \"" + name + "\",");
                System.out.println("    \"value\": \"" + token.getText() + "\",");
                System.out.println("    \"line\": " + token.getLine());
                System.out.print("  }");

                first = false;
            }
        }

        System.out.println("\n]");

        // =====================================================
        // PARSER
        // =====================================================
        tokens.seek(0);
        MiniCParser parser = new MiniCParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorHandler());
        ParseTree tree = parser.program();

        // =====================================================
        // SYNTAX ANALYSIS
        // =====================================================
        System.out.println(
                ConsoleColors.BLUE +
                "\n===== SYNTAX ANALYSIS =====\n" +
                ConsoleColors.RESET
        );

        new SyntaxTreePrinter().print(tree);

        // =====================================================
        // AST
        // =====================================================
        System.out.println(
                ConsoleColors.PURPLE +
                "\n===== ABSTRACT SYNTAX TREE =====\n" +
                ConsoleColors.RESET
        );

        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode astRoot = astBuilder.build(tree);
        new ASTVisualizer().printTree(astRoot);

        // =====================================================
        // SEMANTIC ANALYSIS
        // =====================================================
        System.out.println(
                ConsoleColors.GREEN +
                "\n===== SEMANTIC ANALYSIS =====\n" +
                ConsoleColors.RESET
        );

        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
        semanticAnalyzer.analyze(tree);

        // =====================================================
        // SYMBOL TABLE
        // =====================================================
        System.out.println(
                ConsoleColors.YELLOW +
                "\n===== SYMBOL TABLE =====\n" +
                ConsoleColors.RESET
        );

        semanticAnalyzer.printSymbolTable();

        // =====================================================
        // INTERMEDIATE CODE — TAC
        // =====================================================
        System.out.println(
                ConsoleColors.CYAN +
                "\n===== INTERMEDIATE CODE (TAC) =====\n" +
                ConsoleColors.RESET
        );

        TACGenerator tacGenerator = new TACGenerator();
        tacGenerator.generate(astRoot);

        // =====================================================
        // QUADRUPLES
        // =====================================================
        System.out.println(
                ConsoleColors.PURPLE +
                "\n===== QUADRUPLES =====\n" +
                ConsoleColors.RESET
        );

        QuadrupleGenerator quadGen = new QuadrupleGenerator();
        quadGen.generate(astRoot);

        // =====================================================
        // TRIPLES
        // =====================================================
        System.out.println(
                ConsoleColors.BLUE +
                "\n===== TRIPLES =====\n" +
                ConsoleColors.RESET
        );

        TripleGenerator tripleGen = new TripleGenerator();
        tripleGen.generate(astRoot);

        // =====================================================
        // DEAD CODE ELIMINATION
        // =====================================================
        System.out.println(
                ConsoleColors.RED +
                "\n===== DEAD CODE ELIMINATION =====\n" +
                ConsoleColors.RESET
        );

        DeadCodeEliminator dce = new DeadCodeEliminator();
        dce.eliminate(tacGenerator.getTac());

        // =====================================================
        // END
        // =====================================================
        System.out.println(
                ConsoleColors.GREEN +
                "\nCompilation Completed Successfully!" +
                ConsoleColors.RESET
        );
    }
}
