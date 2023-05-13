import java.util.ArrayList;

public class Order {
    private int id;
    private String status;
    private double total_price;
    private ArrayList<Item> items;

    public Order(int id, String status, ArrayList<Item> items) {
        this.id = id;
        this.status = status;
        this.items = items;
        this.total_price = calc_total_price();
    }

    public int get_id() {
        return this.id;
    }

    public String get_status() {
        return this.status;
    }

    public double get_total_price() {
        return this.total_price;
    }

    // this method returns a string of all the items ids and quantities in the order
    // it is used to save the cart in the database of "order" in a one row
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

    public void set_id(int id) {
        this.id = id;
    }

    public void set_status(String status) {
        this.status = status;
    }

    public double calc_total_price() {
        for (Item item : items) {
            this.total_price += item.get_price() * item.get_quantity();
        }
        return this.total_price;
    }
}