import org.antlr.v4.runtime.tree.ParseTree;

public class ASTPrinter {

    public void print(ParseTree tree) {

        printTree(tree, 0);
    }

    private void printTree(ParseTree node, int indent) {

        if (node == null) {
            return;
        }

        // Print indentation
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        // Print node text
        System.out.println("└── " + node.getClass().getSimpleName()
                + " : " + node.getText());

        // Recursively print children
        for (int i = 0; i < node.getChildCount(); i++) {

            printTree(node.getChild(i), indent + 1);
        }
    }
}