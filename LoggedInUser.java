public class LoggedInUser {
    private String user_name;
    private String email;
    private String password;
    private String address;
    private ShoppingCart cart;
    private Order[] orders;

    LoggedInUser(String user_name, String email, String password, String address) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cart = new ShoppingCart();
        this.orders = new Order[100];
    }

    public String get_user_name() {
        // implementation of LoggedInUser.get_user_name
    }

    public String get_email() {
        // implementation of LoggedInUser.get_email
    }

    public String get_password() {
        // implementation of LoggedInUser.get_password
    }

    public String get_address() {
        // implementation of LoggedInUser.get_address
    }

    public ShoppingCart get_shopping_cart() {
        // implementation of LoggedInUser.get_shopping_cart
    }

    public void set_password(String password) {
        // implementation of LoggedInUser.set_password
    }

    public void view_shopping_cart() {
        // implementation of LoggedInUser.view_shopping_cart
    }

    public boolean add_order(Order order) {
        // implementation of LoggedInUser.add_order
    }

    public void checkout(int order_id) {
        // implementation of LoggedInUser.checkout
        // it just sets the order status to "checked out"
    }
}