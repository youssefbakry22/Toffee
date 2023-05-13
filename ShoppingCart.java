import java.util.ArrayList;

/**
 * This class represents the shopping cart of the user. It contains all the
 * information about the items in the cart.
 * 
 * @author Ahmed Waleed
 * @version 1.0
 * @since 2023-5-12
 * @see Item
 * @see User
 */
public class ShoppingCart {
    private ArrayList<Item> items;

    /**
     * This constructor is used to create a new shopping cart.
     */
    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    /**
     * This method returns the items in the cart.
     * 
     * @return ArrayList<Item> items
     */
    public ArrayList<Item> get_items() {
        return this.items;
    }

    /**
     * this method returns a string of all the items ids and quantities in the cart
     * it is used to save the cart items in the database of user in a one row
     * 
     * @return String all_items_id
     */
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

    /**
     * This method adds an item to the cart.
     * 
     * @param item
     * @param quantity
     */
    public void add_item(Item item, double quantity) {
        item.set_quantity(quantity);
        this.items.add(item);
    }

    /**
     * This method displays all the items in the cart.
     */
    public void display_items() {
        int i = 1;
        for (Item item : items) {
            System.out.print("# " + i++);
            System.out.print(item);
            System.out.println("Quantity: " + item.get_quantity());
            System.out.println(); // empty line
        }
    }

    /**
     * This method checks if the cart is empty or not.
     * 
     * @return boolean
     */
    public boolean is_empty() {
        if (items.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}