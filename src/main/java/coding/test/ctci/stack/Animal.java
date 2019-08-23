package coding.test.ctci.stack;


public abstract class Animal {

    private int order;

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String toString(){
        return name;
    }
}
