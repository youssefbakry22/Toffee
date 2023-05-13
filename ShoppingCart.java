import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> get_items() {
        return this.items;
    }

    // this method returns a string of all the items ids and quantities in the cart
    // it is used to save the cart items in the database of user in a one row
    public String get_All_items_ids() {
        String all_items_id = "";
        for (Item item : items) {
            if (item == null)
                break;
            all_items_id += item.get_id() + ":" + item.get_quantity() + ",";
        }
        if (all_items_id.equals("")) {
            return all_items_id;
        }
        all_items_id = all_items_id.substring(0, all_items_id.length() - 1); // remove the last comma
        return all_items_id;
    }

    public void add_item(Item item, double quantity) {
        item.set_quantity(quantity);
        this.items.add(item);
    }

    public void display_items() {
        int i = 1;
        for (Item item : items) {
            System.out.print("# " + i++);
            System.out.print(item);
            System.out.println("Quantity: " + item.get_quantity());
            System.out.println(); // empty line
        }
    }

    public boolean is_empty() {
        if (items.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}