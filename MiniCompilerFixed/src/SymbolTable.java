import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {

    private static class Symbol {
        String type, scope;
        Symbol(String type, String scope) { this.type = type; this.scope = scope; }
    }

    private Map<String, Symbol> table = new LinkedHashMap<>();

    public void addSymbol(String name, String type, String scope) {
        table.put(name, new Symbol(type, scope));
    }

    public void addSymbol(String name, String type) {
        addSymbol(name, type, "local");
    }

    public boolean contains(String name) { return table.containsKey(name); }

    public String getType(String name) {
        Symbol s = table.get(name);
        return s == null ? "unknown" : s.type;
    }

    // ==========================================
    // NORMAL OUTPUT — original format preserved
    // ==========================================
    public void printTable() {
        for (Map.Entry<String, Symbol> e : table.entrySet()) {
            System.out.println("{");
            System.out.println("  \"name\": \"" + e.getKey() + "\",");
            System.out.println("  \"type\": \"" + e.getValue().type + "\"");
            System.out.println("}");
        }
    }

    // ==========================================
    // JSON OUTPUT — original format preserved
    // ==========================================
    public void printAsJsonEntries() {
        int size = table.size(), count = 0;
        for (Map.Entry<String, Symbol> e : table.entrySet()) {
            System.out.println("      {");
            System.out.println("        \"name\": \"" + e.getKey() + "\",");
            System.out.println("        \"type\": \"" + e.getValue().type + "\"");
            System.out.print  ("      }");
            System.out.println(++count < size ? "," : "");
        }
    }
}
