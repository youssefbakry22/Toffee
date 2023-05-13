import java.util.ArrayList;

/**
 * It represents the catalog of goods that customers can order
 * 
 * @author Hazem Magdy
 * @version 1.0
 * @since 2023-5-5
 * @see Item
 */
public class Category {
    private String name;
    private ArrayList<Item> items;

    /**
     * This is the constructor of the class.
     * 
     * @param name
     * @param items
     */
    public Category(String name, ArrayList<Item> items) {
        this.name = name;
        this.items = items;
    }

    /**
     * This method returns the name of the category.
     * 
     * @return String name
     */
    public String get_name() {
        return this.name;
    }

    /**
     * this method returns a string of all the items ids in the category
     * it is used to save the cart in the database of "categories" in a one row
     * 
     * @return String all_items_id
     */
    public String get_all_items_ids() {
        String all_items_id = "";
        for (Item item : items) {
            all_items_id += item.get_id() + ",";
        }
        all_items_id = all_items_id.substring(0, all_items_id.length() - 1); // remove the last comma
        return all_items_id;
    }

    /**
     * This method used to set the name of the category.
     * 
     * @param name
     */
    public void set_name(String name) {
        this.name = name;
    }

    /**
     * This method displays all the items inside the category.
     */
    public void display_items() {
        for (Item item : items) { // for each item in items_array.
            System.out.println(item);
        }
    }

}
