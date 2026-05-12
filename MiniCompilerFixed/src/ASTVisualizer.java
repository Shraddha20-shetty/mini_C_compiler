public class ASTVisualizer {

    // ==========================================
    // ENTRY POINT
    // FIX: removed the duplicate "===== ABSTRACT SYNTAX TREE ====="
    //      header — Main.java already prints it before calling this.
    // ==========================================
    public void printTree(ASTNode root) {

        print(root, "", true);
    }

    // ==========================================
    // TREE PRINT (CHILDREN-BASED AST)
    // ==========================================
    private void print(ASTNode node,
                       String prefix,
                       boolean isLast) {

        if (node == null) return;

        System.out.print(prefix);

        if (isLast) {
            System.out.print("└── ");
            prefix += "    ";
        } else {
            System.out.print("├── ");
            prefix += "│   ";
        }

        System.out.println(node.value);

        for (int i = 0; i < node.children.size(); i++) {

            print(
                    node.children.get(i),
                    prefix,
                    i == node.children.size() - 1
            );
        }
    }
}
