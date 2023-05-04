public class LoggedInUser {
    private String user_name;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String country;
    private boolean active = true;
    private double loyalty_points;
    private int gift_vouchers;
    private ShoppingCart cart;
    private Order[] orders;

    LoggedInUser(String user_name, String email, String password, String address) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cart = new ShoppingCart();
    }

    public void update_user_info(String user_name, String password) {
        // implementation of updating user info
    }

    public void forget_password(String email) {
        // implementation of forget password
    }

    public void add_loyalty_points(double loyalty_points) {
        // implementation of adding loyalty points
    }

    public void add_gift_vouchers(int gift_vouchers) {
        // implementation of adding gift vouchers
    }

    public void add_item_toCart(Item item) {
        // implementation of adding item to cart
    }

    public void remove_item_fromCart(String name) {
        // implementation of removing item from cart
    }

    public void view_shopping_cart() {
        // implementation of viewing shopping cart
    }

    public boolean place_order() {
        // implementation of placing an order
        return true;
    }

    public void checkout() {
        // implementation of checkout
    }

    public void view_orders_history() {
        // implementation of viewing orders history
    }

    public boolean reorder(Order order) {
        // implementation of reordering
        return true;
    }
}