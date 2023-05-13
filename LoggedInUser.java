import java.util.ArrayList;

public class LoggedInUser {
    private String user_name;
    private String email;
    private String password;
    private String address;
    private ShoppingCart cart;
    private ArrayList<Order> orders;

    LoggedInUser(String user_name, String email, String password, String address) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cart = new ShoppingCart();
        this.orders = new ArrayList<Order>();
    }

    public String get_user_name() {
        return this.user_name;
    }

    public String get_email() {
        return this.email;
    }

    public String get_password() {
        return this.password;
    }

    public String get_address() {
        return this.address;
    }

    public ShoppingCart get_shopping_cart() {
        return this.cart;
    }

    // this method is used to get all the orders ids in a string separated by comma
    // it is used to save the orders in the database of "user"
    public String get_all_orders_ids() {
        String orders_id = "";
        for (Order order : orders) {
            orders_id += order.get_id() + ",";
        }
        if (orders_id == "") {
            return orders_id;
        }
        orders_id = orders_id.substring(0, orders_id.length() - 1); // remove the last comma
        return orders_id;
    }

    public void set_password(String password) {
        this.password = password;
    }

    public void view_shopping_cart() {
        this.cart.display_items();
    }

    public void add_order(Order order) {
        this.orders.add(order);
    }

    public void checkout(int order_id) {
        for (Order order : orders) {
            if (order.get_id() == order_id) {
                order.set_status("checked out");
            }
        }
    }

}