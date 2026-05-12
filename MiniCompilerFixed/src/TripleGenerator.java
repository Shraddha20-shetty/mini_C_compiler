import java.util.ArrayList;
import java.util.List;

public class TripleGenerator {

    private int tempCount  = 1;
    private int labelCount = 1;
    private List<String[]> triples = new ArrayList<>();

    public void generate(ASTNode root) {
        traverse(root);
        if (triples.isEmpty()) { System.out.println("No triples generated"); return; }

        // ---- box table ----
        int w0=5, w1=10, w2=14, w3=14;
        System.out.println("┌"+bar(w0)+"┬"+bar(w1)+"┬"+bar(w2)+"┬"+bar(w3)+"┐");
        System.out.println("│"+c("No.",w0)+"│"+c("Operator",w1)+"│"+c("Operand1",w2)+"│"+c("Operand2",w3)+"│");
        System.out.println("├"+bar(w0)+"┼"+bar(w1)+"┼"+bar(w2)+"┼"+bar(w3)+"┤");
        for (int i = 0; i < triples.size(); i++) {
            String[] t = triples.get(i);
            System.out.println("│"+c("("+i+")",w0)+"│"+c(t[0],w1)+"│"+c(t[1],w2)+"│"+c(t[2],w3)+"│");
        }
        System.out.println("└"+bar(w0)+"┴"+bar(w1)+"┴"+bar(w2)+"┴"+bar(w3)+"┘");

        // ---- JSON ----
        System.out.println(
            ConsoleColors.CYAN +
            "\n===== TRIPLES — JSON =====\n" +
            ConsoleColors.RESET
        );
        System.out.println("{");
        System.out.println("  \"triples\": [");
        for (int i = 0; i < triples.size(); i++) {
            String[] t = triples.get(i);
            System.out.println("    {");
            System.out.println("      \"index\"   : \"(" + i + ")\",");
            System.out.println("      \"operator\": \"" + t[0] + "\",");
            System.out.println("      \"operand1\": \"" + t[1] + "\",");
            System.out.println("      \"operand2\": \"" + t[2] + "\"");
            System.out.print  ("    }");
            System.out.println(i < triples.size() - 1 ? "," : "");
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
                    triples.add(new String[]{"=", v, rhs}); return "("+(triples.size()-1)+")";
                }
                return node.children.size() >= 2 ? node.children.get(1).value : "_";
            case "ARRAY_DECL":
                triples.add(new String[]{"alloc", node.children.get(1).value, node.children.get(2).value});
                return "("+(triples.size()-1)+")";
            case "=":
                String l = node.children.get(0).value, r = traverse(node.children.get(1));
                triples.add(new String[]{"=", l, r}); return "("+(triples.size()-1)+")";
            case "ARRAY_ASSIGN": {
                String name=node.children.get(0).value, idx=traverse(node.children.get(1)), val=traverse(node.children.get(2));
                triples.add(new String[]{"[]=", name+"["+idx+"]", val}); return "("+(triples.size()-1)+")";
            }
            case "PRINT": {
                String arg = node.children.isEmpty() ? "_" : traverse(node.children.get(0));
                triples.add(new String[]{"print", arg, "_"}); return "("+(triples.size()-1)+")";
            }
            case "IF": {
                String lt="L"+labelCount++, lf="L"+labelCount++, le="L"+labelCount++;
                ASTNode cond = node.children.get(0);
                String lhs=traverse(cond.children.get(0)), op=cond.children.get(1).value, rhs=traverse(cond.children.get(2));
                triples.add(new String[]{"if "+op, lhs, rhs});
                triples.add(new String[]{"goto", lt, "_"});
                triples.add(new String[]{"label", lt, "_"});
                for (ASTNode s : node.children.get(1).children) traverse(s);
                triples.add(new String[]{"goto", le, "_"});
                triples.add(new String[]{"label", lf, "_"});
                if (node.children.size()==3) for (ASTNode s : node.children.get(2).children) traverse(s);
                triples.add(new String[]{"label", le, "_"}); return "("+(triples.size()-1)+")";
            }
            case "WHILE": {
                String ls="L"+labelCount++, lb="L"+labelCount++, le="L"+labelCount++;
                triples.add(new String[]{"label", ls, "_"});
                ASTNode cond = node.children.get(0);
                String lhs=traverse(cond.children.get(0)), op=cond.children.get(1).value, rhs=traverse(cond.children.get(2));
                triples.add(new String[]{"if "+op, lhs, rhs});
                triples.add(new String[]{"goto", lb, "_"});
                triples.add(new String[]{"label", lb, "_"});
                for (ASTNode s : node.children.get(1).children) traverse(s);
                triples.add(new String[]{"goto", ls, "_"});
                triples.add(new String[]{"label", le, "_"}); return "("+(triples.size()-1)+")";
            }
            case "ARRAY_ACCESS": {
                String name=node.children.get(0).value, idx=traverse(node.children.get(1));
                triples.add(new String[]{"[]", name, idx}); return "("+(triples.size()-1)+")";
            }
            case "+": case "-": case "*": case "/": {
                String lhs=traverse(node.children.get(0)), rhs=traverse(node.children.get(1));
                triples.add(new String[]{node.value, lhs, rhs}); return "("+(triples.size()-1)+")";
            }
            default: return node.value;
        }
    }
}
