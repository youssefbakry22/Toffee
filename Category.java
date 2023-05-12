
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

    public String get_all_items_ids() {
        String all_items_id = "";
        for (Item item : items) {
            if (item != null) {
                all_items_id += item.get_id() + ",";
            }
        }
        all_items_id = all_items_id.substring(0, all_items_id.length() - 1);
        return all_items_id;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void display_items() {
        for (Item item : items) { // for each item in items_array.
            if (item != null) { // if current index is not empty .
                System.out.println(item);
            }
        }
    }

}
