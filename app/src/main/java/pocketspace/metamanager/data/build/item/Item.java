package pocketspace.metamanager.data.build.item;

public class Item {
    private String name;
    private int quantity = 1;
    public Item(String name) {
        this.name = name;
    }
    public Item(String name, int quantity){
        this.name = name;
        setQuantity(quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        if (validQuantity(quantity))
            this.quantity = quantity;
    }
    private boolean validQuantity(int quantity) {
        return quantity >= 1;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
