import java.util.ArrayList;

/**
 * This class represents the user of the system specially logged in users.
 * It contains all the information about the user.
 * 
 * @author Ahmed Waleed
 * @version 1.0
 * @since 2023-5-12
 * @see ShoppingCart
 * @see Order
 */
public class User {
    private String user_name;
    private String email;
    private String password;
    private String address;
    private ShoppingCart cart;
    private ArrayList<Order> orders;

    /**
     * This constructor is used to create a new user.
     * 
     * @param user_name
     * @param email
     * @param password
     * @param address
     */
    User(String user_name, String email, String password, String address) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cart = new ShoppingCart();
        this.orders = new ArrayList<Order>();
    }

    /**
     * This method returns the user name of the user.
     * 
     * @return String user_name
     */
    public String get_user_name() {
        return this.user_name;
    }

    /**
     * This method returns the email of the user.
     * 
     * @return
     */
    public String get_email() {
        return this.email;
    }

    /**
     * This method returns the password of the user.
     * 
     * @return String password
     */
    public String get_password() {
        return this.password;
    }

    /**
     * This method returns the address of the user.
     * 
     * @return String address
     */
    public String get_address() {
        return this.address;
    }

    /**
     * This method returns the shopping cart of the user.
     * 
     * @return ShoppingCart
     */
    public ShoppingCart get_shopping_cart() {
        return this.cart;
    }

    /**
     * this method is used to get all the orders ids in a string separated by comma
     * it is used to save the orders in the database of "user" in one row
     * 
     * @return String orders_id separated by comma
     */
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

    /**
     * This method is used to set the password of the user.
     * 
     * @param password
     */
    public void set_password(String password) {
        this.password = password;
    }

    /**
     * this method is used to display the shopping cart of the user.
     */
    public void view_shopping_cart() {
        this.cart.display_items();
    }

    /**
     * This method is used to add an order to the user.
     * 
     * @param order
     */
    public void add_order(Order order) {
        this.orders.add(order);
    }

    /**
     * this method is used to checkout the order with the given id.
     * 
     * @param order_id
     */
    public void checkout(int order_id) {
        for (Order order : orders) {
            if (order.get_id() == order_id) {
                order.set_status("checked out");
            }
        }
    }

}