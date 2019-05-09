package pocketspace.metamanager.data.build.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemBlock {
    private String title = "";
    private List<Item> items = null;

    public ItemBlock() {
    }
    public ItemBlock(String title) {
        this.title = title;
        this.items = new ArrayList<>();
    }
    public ItemBlock(String title, List<Item> items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public ItemBlock add(Item itemName){
        items.add(itemName);
        return this;
    }
    public void addAll(Collection<? extends Item> c) {
        items.addAll(c);
    }
    public Item getItem(int index) {
        return items.get(index);
    }
    public List<Item> getItems() {
        return items;
    }
}
