import java.util.ArrayList;
import java.util.List;

public class ASTNode {

    public String value;
    public List<ASTNode> children;

    public ASTNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(ASTNode node) {
        if (node != null) {
            children.add(node);
        }
    }
}