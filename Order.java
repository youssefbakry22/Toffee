import java.util.ArrayList;

public class Order {
    private int id;
    private String status;
    private double total_price;
    private ArrayList<Item>  items;

    public Order(int id, String status, ArrayList<Item> items) {
        this.id = id;
        this.status = status;
        this.items = items;
        this.total_price = calc_total_price();
    }

    public int get_id() {
        // implementation of Order.get_id
        return id;
    }

    public String get_status() {
        // implementation of Order.get_status
        return status;
    }

    public double get_total_price() {
        // implementation of Order.get_total_price
        return total_price;
    }

    public void set_id(int id) {
        // implementation of Order.set_id
        this.id=id;
    }

    public void set_status(String status) {
        // implementation of Order.set_status
        this.status=status;
    }

    public double calc_total_price() {
        // implementation of Order.calc_total_price
        for(int i=0;i<items.size();i++){
            total_price+=items[i].get_price()*items[i].get_quantity();
        }
        return total_price;
    }
}
