import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Item> items;

    public Category(String name, ArrayList<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String get_name() {
        return this.name;
    }

    public String get_all_items_ids() {
        String all_items_id = "";
        for (Item item : items) {
            all_items_id += item.get_id() + ",";
        }
        all_items_id = all_items_id.substring(0, all_items_id.length() - 1); // remove the last comma
        return all_items_id;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void display_items() {
        for (Item item : items) { // for each item in items_array.
            System.out.println(item);
        }
    }

}
