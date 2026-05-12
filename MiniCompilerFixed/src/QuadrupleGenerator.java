import java.util.ArrayList;
import java.util.List;

public class QuadrupleGenerator {

    private int tempCount  = 1;
    private int labelCount = 1;
    private List<String[]> quads = new ArrayList<>();

    public void generate(ASTNode root) {
        traverse(root);
        if (quads.isEmpty()) { System.out.println("No quadruples generated"); return; }

        // ---- box table ----
        int w0=5, w1=10, w2=12, w3=12, w4=10;
        System.out.println("┌"+bar(w0)+"┬"+bar(w1)+"┬"+bar(w2)+"┬"+bar(w3)+"┬"+bar(w4)+"┐");
        System.out.println("│"+c("No.",w0)+"│"+c("Operator",w1)+"│"+c("Operand1",w2)+"│"+c("Operand2",w3)+"│"+c("Result",w4)+"│");
        System.out.println("├"+bar(w0)+"┼"+bar(w1)+"┼"+bar(w2)+"┼"+bar(w3)+"┼"+bar(w4)+"┤");
        for (int i = 0; i < quads.size(); i++) {
            String[] q = quads.get(i);
            System.out.println("│"+c(String.valueOf(i+1),w0)+"│"+c(q[0],w1)+"│"+c(q[1],w2)+"│"+c(q[2],w3)+"│"+c(q[3],w4)+"│");
        }
        System.out.println("└"+bar(w0)+"┴"+bar(w1)+"┴"+bar(w2)+"┴"+bar(w3)+"┴"+bar(w4)+"┘");

        // ---- JSON ----
        System.out.println(
            ConsoleColors.CYAN +
            "\n===== QUADRUPLES — JSON =====\n" +
            ConsoleColors.RESET
        );
        System.out.println("{");
        System.out.println("  \"quadruples\": [");
        for (int i = 0; i < quads.size(); i++) {
            String[] q = quads.get(i);
            System.out.println("    {");
            System.out.println("      \"no\"      : " + (i + 1) + ",");
            System.out.println("      \"operator\": \"" + q[0] + "\",");
            System.out.println("      \"operand1\": \"" + q[1] + "\",");
            System.out.println("      \"operand2\": \"" + q[2] + "\",");
            System.out.println("      \"result\"  : \"" + q[3] + "\"");
            System.out.print  ("    }");
            System.out.println(i < quads.size() - 1 ? "," : "");
        }
        System.out.println("  ]");
        System.out.println("}");
    }

    private String bar(int w){StringBuilder sb=new StringBuilder();for(int i=0;i<w;i++)sb.append('─');return sb.toString();}
    private String c(String s,int w){if(s.length()>=w)return " "+s+" ";int t=w-s.length();int l=t/2;int r=t-l;return " ".repeat(l)+s+" ".repeat(r);}

    private String traverse(ASTNode node) {
        if (node == null) return "_";
        switch (node.value) {
            case "EMPTY": return "_";
            case "Program": for (ASTNode ch : node.children) traverse(ch); return "_";
            case "DECL":
                if (node.children.size() == 3) {
                    String v = node.children.get(1).value, rhs = traverse(node.children.get(2));
                    quads.add(new String[]{"=", rhs, "_", v}); return v;
                }
                return node.children.size() >= 2 ? node.children.get(1).value : "_";
            case "ARRAY_DECL":
                quads.add(new String[]{"alloc", node.children.get(1).value, node.children.get(2).value, "_"}); return "_";
            case "=":
                String l = node.children.get(0).value, r = traverse(node.children.get(1));
                quads.add(new String[]{"=", r, "_", l}); return l;
            case "ARRAY_ASSIGN": {
                String name = node.children.get(0).value, idx = traverse(node.children.get(1)), val = traverse(node.children.get(2));
                quads.add(new String[]{"[]=", name+"["+idx+"]", val, "_"}); return "_";
            }
            case "PRINT": {
                String arg = node.children.isEmpty() ? "_" : traverse(node.children.get(0));
                quads.add(new String[]{"print", arg, "_", "_"}); return "_";
            }
            case "IF": {
                String lt="L"+labelCount++, lf="L"+labelCount++, le="L"+labelCount++;
                ASTNode cond = node.children.get(0);
                String lhs=traverse(cond.children.get(0)), op=cond.children.get(1).value, rhs=traverse(cond.children.get(2));
                quads.add(new String[]{"if "+op, lhs, rhs, lt});
                quads.add(new String[]{"goto", "_", "_", lf});
                quads.add(new String[]{"label", lt, "_", "_"});
                for (ASTNode s : node.children.get(1).children) traverse(s);
                quads.add(new String[]{"goto", "_", "_", le});
                quads.add(new String[]{"label", lf, "_", "_"});
                if (node.children.size()==3) for (ASTNode s : node.children.get(2).children) traverse(s);
                quads.add(new String[]{"label", le, "_", "_"}); return "_";
            }
            case "WHILE": {
                String ls="L"+labelCount++, lb="L"+labelCount++, le="L"+labelCount++;
                quads.add(new String[]{"label", ls, "_", "_"});
                ASTNode cond = node.children.get(0);
                String lhs=traverse(cond.children.get(0)), op=cond.children.get(1).value, rhs=traverse(cond.children.get(2));
                quads.add(new String[]{"if "+op, lhs, rhs, lb});
                quads.add(new String[]{"goto", "_", "_", le});
                quads.add(new String[]{"label", lb, "_", "_"});
                for (ASTNode s : node.children.get(1).children) traverse(s);
                quads.add(new String[]{"goto", "_", "_", ls});
                quads.add(new String[]{"label", le, "_", "_"}); return "_";
            }
            case "ARRAY_ACCESS": {
                String name=node.children.get(0).value, idx=traverse(node.children.get(1)), t="t"+tempCount++;
                quads.add(new String[]{"[]", name, idx, t}); return t;
            }
            case "+": case "-": case "*": case "/": {
                String lhs=traverse(node.children.get(0)), rhs=traverse(node.children.get(1)), t="t"+tempCount++;
                quads.add(new String[]{node.value, lhs, rhs, t}); return t;
            }
            default: return node.value;
        }
    }
}
