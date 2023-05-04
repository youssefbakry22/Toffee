public class AppSystem {
    private LoggedInUser[] users;
    private Item[] items;
    private Category[] categories;
    private Order[] orders;
    private Admin[] admins;
    private Storage storage;
    private int otp;

    public AppSystem() {
        this.users = new LoggedInUser[100];
        this.items = new Item[100];
        this.categories = new Category[100];
        this.orders = new Order[100];
        this.admins = new Admin[100];
        this.storage = new Storage();

        // load system data
        this.load_system_data();
    }

    public boolean validate_credentials(String user_name, String password) {
        // validate credentials code
        return true;
    }

    public void add_user(LoggedInUser user) {
        // add user code
    }

    public void add_item(Item item) {
        // add item code
    }

    public void add_category(Category category) {
        // add category code
    }

    public void add_order(Order order) {
        // add order code
    }

    public void add_admin(Admin admin) {
        // add admin code
    }

    public Catalog create_catalog() {
        // create catalog code
        return new Catalog(categories);
    }

    public void modify_user(String user_name) {
        // modify user code
    }

    public void modify_item(int item_id) {
        // modify item code
    }

    public void modify_category(String category_name) {
        // modify category code
    }

    public void save_system_data() {
        storage.save_data(users, orders, items, categories, admins);
    }

    public void load_system_data() {
        storage.load_data(users, orders, items, categories, admins);
    }

    public void apply_loyalty_points(double loyalty_points) {
        // apply loyalty points code
    }

    public int send_OTP_email(String email) {
        otp = 1234;
        return otp;
    }

    public int send_OTP_phone(String phone) {
        otp = 1234;
        return otp;
    }

    public boolean verify_OTP(int otp) {
        return this.otp == otp;
    }
}