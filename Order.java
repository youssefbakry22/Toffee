import java.util.ArrayList;

/**
 * It represents an order placed by a user. It contains information about the
 * items ordered
 * 
 * @author Ahmed Waleed
 * @version 1.0
 * @since 2023-5-12
 * @see Item
 */
public class Order {
    private int id;
    private String status;
    private double total_price;
    private ArrayList<Item> items;

    /**
     * This constructor is used to create a new order.
     * 
     * @param id
     * @param status
     * @param items
     */
    public Order(int id, String status, ArrayList<Item> items) {
        this.id = id;
        this.status = status;
        this.items = items;
        this.total_price = calc_total_price();
    }

    /**
     * This method returns the id of the order.
     * 
     * @return int id
     */
    public int get_id() {
        return this.id;
    }

    /**
     * This method returns the status of the order.
     * 
     * @return String status
     */
    public String get_status() {
        return this.status;
    }

    /**
     * This method returns the total price of the order.
     * 
     * @return double total_price
     */
    public double get_total_price() {
        return this.total_price;
    }

    /**
     * this method returns a string of all the items ids and quantities in the order
     * it is used to save the cart in the database of "order" in a one row
     * 
     * @return String all_items_id
     */
    public String get_All_items_ids() {
        String all_items_id = "";
        for (Item item : items) {
            all_items_id += item.get_id() + ":" + item.get_quantity() + ",";
        }
        if (all_items_id.equals("")) {
            return all_items_id;
        }
        all_items_id = all_items_id.substring(0, all_items_id.length() - 1); // remove the last comma
        return all_items_id;
    }

    /**
     * This method used to set the id of the order.
     * 
     * @param id
     */
    public void set_id(int id) {
        this.id = id;
    }

    /**
     * This method used to set the status of the order.
     * 
     * @param status
     */
    public void set_status(String status) {
        this.status = status;
    }

    /**
     * This method calculates the total price of the order.
     * 
     * @return double total_price
     */
    public double calc_total_price() {
        for (Item item : items) {
            this.total_price += item.get_price() * item.get_quantity();
        }
        return this.total_price;
    }
}