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
        this.orders = new ArrayList<Order>(100);
    }

    public String get_user_name() {
        // implementation of LoggedInUser.get_user_name
        return user_name;
    }

    public String get_email() {
        // implementation of LoggedInUser.get_email
        return email;
    }

    public String get_password() {
        // implementation of LoggedInUser.get_password
        return password;
    }

    public String get_address() {
        // implementation of LoggedInUser.get_address
        return address;
    }

    public ShoppingCart get_shopping_cart() {
        // implementation of LoggedInUser.get_shopping_cart
        return cart;
    }

    public void set_password(String password) {
        // implementation of LoggedInUser.set_password
        this.password=passwod;
    }

    public void view_shopping_cart() {
        // implementation of LoggedInUser.view_shopping_cart
        cart.display_items();
    }

    public void add_order(Order order) {
        // implementation of LoggedInUser.add_order
        orders.add(order);
    }

    public void checkout(int order_id) {
        // implementation of LoggedInUser.checkout
        // it just sets the order status to "checked out"
        for(int i=0;i<orders.size();i++){
            if(orders[i].get_id()==order_id){
                orders[i].set_status("placed");
            }
        }
    }
}
