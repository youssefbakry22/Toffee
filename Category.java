
public class Category {
    private String name;
    private Item[] items;

    public Category(String name, Item[] items) {
        this.name = name;
        this.items = items;
    }

    public String get_name() {
        return this.name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void add_item(Item item) {
        // add item to category
    }

    public void display_items() {
        // display items in category
    }
}