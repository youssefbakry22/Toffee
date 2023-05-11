public class Order {
    private int id;
    private String status;
    private double total_price;
    private Item[] items;

    public Order(int id, String status, Item[] items) {
        this.id = id;
        this.status = status;
        this.items = items;
        this.total_price = calc_total_price();
    }

    public int get_id() {
        // implementation of Order.get_id
    }

    public String get_status() {
        // implementation of Order.get_status
    }

    public double get_total_price() {
        // implementation of Order.get_total_price
    }

    public void set_id(int id) {
        // implementation of Order.set_id
    }

    public void set_status(String status) {
        // implementation of Order.set_status
    }

    public double calc_total_price() {
        // implementation of Order.calc_total_price
    }
}