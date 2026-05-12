import org.antlr.v4.runtime.tree.ParseTree;

public class ASTBuilder {

    public ASTNode build(ParseTree tree) {
        ASTNode root = new ASTNode("Program");
        for (int i = 0; i < tree.getChildCount(); i++) {
            ASTNode node = buildNode(tree.getChild(i));
            if (node != null) root.addChild(node);
        }
        return root;
    }

    private ASTNode buildNode(ParseTree node) {
        if (node == null) return null;

        // unwrap single-child wrappers
        if (node.getChildCount() == 1) return buildNode(node.getChild(0));

        // ---- DECLARATION  int a = 10; / int a; ----
        if (node instanceof MiniCParser.DeclarationContext) {
            ASTNode decl = new ASTNode("DECL");
            decl.addChild(new ASTNode(node.getChild(0).getText())); // type
            decl.addChild(new ASTNode(node.getChild(1).getText())); // name
            if (node.getChildCount() == 5)
                decl.addChild(buildExpr(node.getChild(3)));
            return decl;
        }

        // ---- ARRAY DECLARATION  int list[10]; ----
        if (node instanceof MiniCParser.ArrayDeclarationContext) {
            ASTNode arr = new ASTNode("ARRAY_DECL");
            arr.addChild(new ASTNode(node.getChild(0).getText()));
            arr.addChild(new ASTNode(node.getChild(1).getText()));
            arr.addChild(new ASTNode(node.getChild(3).getText()));
            return arr;
        }

        // ---- ASSIGNMENT  c = expr; ----
        if (node instanceof MiniCParser.AssignmentContext) {
            ASTNode assign = new ASTNode("=");
            assign.addChild(new ASTNode(node.getChild(0).getText()));
            assign.addChild(buildExpr(node.getChild(2)));
            return assign;
        }

        // ---- ARRAY ASSIGNMENT  list[i] = expr; ----
        if (node instanceof MiniCParser.ArrayAssignmentContext) {
            ASTNode assign = new ASTNode("ARRAY_ASSIGN");
            assign.addChild(new ASTNode(node.getChild(0).getText()));
            assign.addChild(buildExpr(node.getChild(2)));
            assign.addChild(buildExpr(node.getChild(5)));
            return assign;
        }

        // ---- PRINT ----
        if (node instanceof MiniCParser.PrintStatementContext) {
            ASTNode print = new ASTNode("PRINT");
            print.addChild(buildExpr(node.getChild(2)));
            return print;
        }

        // ---- IF ----
        if (node instanceof MiniCParser.IfStatementContext) {
            ASTNode ifNode = new ASTNode("IF");
            ifNode.addChild(buildCondition(node.getChild(2)));
            ASTNode thenBlock = new ASTNode("THEN");
            int i = 4;
            while (i < node.getChildCount() && !node.getChild(i).getText().equals("}")) {
                ASTNode s = buildNode(node.getChild(i));
                if (s != null) thenBlock.addChild(s);
                i++;
            }
            ifNode.addChild(thenBlock);
            i++;
            if (i < node.getChildCount() && node.getChild(i).getText().equals("else")) {
                ASTNode elseBlock = new ASTNode("ELSE");
                i += 2;
                while (i < node.getChildCount() && !node.getChild(i).getText().equals("}")) {
                    ASTNode s = buildNode(node.getChild(i));
                    if (s != null) elseBlock.addChild(s);
                    i++;
                }
                ifNode.addChild(elseBlock);
            }
            return ifNode;
        }

        // ---- WHILE ----
        if (node instanceof MiniCParser.WhileStatementContext) {
            ASTNode whileNode = new ASTNode("WHILE");
            whileNode.addChild(buildCondition(node.getChild(2)));
            ASTNode body = new ASTNode("BODY");
            int i = 4;
            while (i < node.getChildCount() && !node.getChild(i).getText().equals("}")) {
                ASTNode s = buildNode(node.getChild(i));
                if (s != null) body.addChild(s);
                i++;
            }
            whileNode.addChild(body);
            return whileNode;
        }

        // ---- FOR ----
        if (node instanceof MiniCParser.ForStatementContext) {
            ASTNode forNode = new ASTNode("FOR");

            // child(2) = forInit
            ASTNode initNode = buildForInit(node.getChild(2));
            forNode.addChild(initNode != null ? initNode : new ASTNode("EMPTY"));

            // child(4) = condition
            forNode.addChild(buildCondition(node.getChild(4)));

            // child(6) = forUpdate
            ASTNode updateNode = buildForUpdate(node.getChild(6));
            forNode.addChild(updateNode != null ? updateNode : new ASTNode("EMPTY"));

            // body: between { and }
            ASTNode body = new ASTNode("BODY");
            int i = 8;
            while (i < node.getChildCount() && !node.getChild(i).getText().equals("}")) {
                ASTNode s = buildNode(node.getChild(i));
                if (s != null) body.addChild(s);
                i++;
            }
            forNode.addChild(body);
            return forNode;
        }

        return null;
    }

    // ---- FOR INIT:  type id = expr  OR  id = expr  OR empty ----
    private ASTNode buildForInit(ParseTree node) {
        if (node == null || node.getChildCount() == 0) return null;

        // type id = expr  → 4 children
        if (node.getChildCount() == 4) {
            ASTNode decl = new ASTNode("DECL");
            decl.addChild(new ASTNode(node.getChild(0).getText())); // type
            decl.addChild(new ASTNode(node.getChild(1).getText())); // name
            decl.addChild(buildExpr(node.getChild(3)));             // expr
            return decl;
        }

        // id = expr  → 3 children
        if (node.getChildCount() == 3) {
            ASTNode assign = new ASTNode("=");
            assign.addChild(new ASTNode(node.getChild(0).getText()));
            assign.addChild(buildExpr(node.getChild(2)));
            return assign;
        }

        return null;
    }

    // ---- FOR UPDATE:  id = expr  OR empty ----
    private ASTNode buildForUpdate(ParseTree node) {
        if (node == null || node.getChildCount() == 0) return null;

        // id = expr  → 3 children
        if (node.getChildCount() == 3) {
            ASTNode assign = new ASTNode("=");
            assign.addChild(new ASTNode(node.getChild(0).getText()));
            assign.addChild(buildExpr(node.getChild(2)));
            return assign;
        }

        return null;
    }

    private ASTNode buildCondition(ParseTree node) {
        if (node == null) return new ASTNode("?");
        ASTNode cond = new ASTNode("COND");
        cond.addChild(buildExpr(node.getChild(0)));
        cond.addChild(new ASTNode(node.getChild(1).getText()));
        cond.addChild(buildExpr(node.getChild(2)));
        return cond;
    }

    private ASTNode buildExpr(ParseTree node) {
        if (node == null) return null;
        if (node.getChildCount() == 0) return new ASTNode(node.getText());
        if (node.getChildCount() == 1) return buildExpr(node.getChild(0));

        // array access  id[expr]
        if (node.getChildCount() == 4 && node.getChild(1).getText().equals("[")) {
            ASTNode access = new ASTNode("ARRAY_ACCESS");
            access.addChild(new ASTNode(node.getChild(0).getText()));
            access.addChild(buildExpr(node.getChild(2)));
            return access;
        }

        // binary  expr op expr
        if (node.getChildCount() == 3) {
            String op = node.getChild(1).getText();
            if (op.equals(")") || node.getChild(0).getText().equals("("))
                return buildExpr(node.getChild(1));
            ASTNode opNode = new ASTNode(op);
            opNode.addChild(buildExpr(node.getChild(0)));
            opNode.addChild(buildExpr(node.getChild(2)));
            return opNode;
        }

        return new ASTNode(node.getText());
    }
}
