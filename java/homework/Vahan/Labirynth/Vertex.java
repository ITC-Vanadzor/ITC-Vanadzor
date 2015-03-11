
public class Vertex {
    private final String id;
    private int value;
    public Vertex(String id, int value) {
        this.id = id;
        this.value = value;
    }
    

    public String getId() {
        return this.id;
    }

    public int getVal() {
        return this.value;
    }
    
    public void setVal(int val) {
        this.value = val;
    }
    
}
