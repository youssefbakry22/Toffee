public class Order {
    private int id;
    private String customer_name;
    private Item[] items;
    private double total_price;
    private String status;

    public Order(int id, Item[] items, String status) {
        this.id = id;
        this.items = items;
        this.total_price = 0.0;
        this.status = status;
    }

    public int get_id() {
        return this.id;
    }

    public String get_customer_name() {
        return this.customer_name;
    }

    public String get_status() {
        return this.status;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public void set_status(String status) {
        this.status = status;
    }
}