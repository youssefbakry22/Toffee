import java.util.ArrayList;
import java.io.*;

/**
 * This class is responsible for saving and loading data.
 * 
 * @author Youssef Bakry
 * @version 1.0
 * @since 2023-5-7
 */
public class Storage {
    private final String USERS_FILE = "storage/users.txt";
    private final String ORDERS_FILE = "storage/orders.txt";
    private final String ITEMS_FILE = "storage/items.txt";
    private final String CATEGORIES_FILE = "storage/categories.txt";

    /**
     * This method saves the data of the system in the files.
     */
    public void save_data(ArrayList<User> users, ArrayList<Order> orders, ArrayList<Item> items,
            ArrayList<Category> categories) {
        try {
            // save users
            PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE));
            for (User user : users) {
                writer.println(encrypt_decrypt(user.get_user_name() + "," + user.get_email() + ","
                        + user.get_password() + ","
                        + user.get_address(), 10));
                writer.println(user.get_shopping_cart().get_All_items_ids());
                writer.println(user.get_all_orders_ids());
            }
            writer.close();

            // save orders
            writer = new PrintWriter(new FileWriter(ORDERS_FILE));
            for (Order order : orders) {
                writer.println(order.get_id() + "," + order.get_status());
                writer.println(order.get_All_items_ids());
            }
            writer.close();

            // save items
            writer = new PrintWriter(new FileWriter(ITEMS_FILE));
            for (Item item : items) {
                writer.println(item.get_name() + "," + item.get_id() + "," + item.get_description() + "," +
                        item.get_category() + "," + item.get_unit() + "," +
                        item.get_price());
            }
            writer.close();

            // save categories
            writer = new PrintWriter(new FileWriter(CATEGORIES_FILE));
            for (Category category : categories) {
                writer.println(category.get_name());
                writer.println(category.get_all_items_ids());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    // =======================================================================================================

    /**
     * This method loads the data of the system from the files.
     */
    public void load_data(AppSystem system) {
        try {
            String line;

            // load items
            BufferedReader reader = new BufferedReader(new FileReader(ITEMS_FILE));
            while ((line = reader.readLine()) != null) {
                String[] item_data = line.split(",");
                String name = item_data[0];
                int id = Integer.parseInt(item_data[1]);
                String description = item_data[2];
                String category = item_data[3];
                String unit = item_data[4];
                double price = Double.parseDouble(item_data[5]);
                Item item = new Item(name, id, description, category, unit, 1, price);
                system.add_item(item);
            }
            reader.close();

            // load orders
            reader = new BufferedReader(new FileReader(ORDERS_FILE));
            while ((line = reader.readLine()) != null) {
                String[] order_data = line.split(",");

                int order_id = Integer.parseInt(order_data[0]);
                String status = order_data[1];

                String[] token = reader.readLine().split(",");
                ArrayList<Item> items = new ArrayList<Item>();
                for (int i = 0; i < token.length; i++) {
                    String id_quantity[] = token[i].split(":");
                    Item item_ = system.get_item_by_id(Integer.parseInt(id_quantity[0]));
                    item_.set_quantity(Double.parseDouble(id_quantity[1]));
                    items.add(item_);
                    // items_ids[i] = system.get_item_by_id(Integer.parseInt(id_quantity[0]));
                    // items_ids[i].set_quantity(Double.parseDouble(id_quantity[1]));
                }
                Order order = new Order(order_id, status, items);
                system.add_order(order);
            }
            reader.close();

            // load users
            reader = new BufferedReader(new FileReader(USERS_FILE));
            while ((line = reader.readLine()) != null) {
                line = encrypt_decrypt(line, -10);
                System.out.println(line);
                String[] user_data = line.split(",");
                String user_name = user_data[0];
                String email = user_data[1];
                String password = user_data[2];
                String address = user_data[3];
                User user = new User(user_name, email, password, address);

                String[] shopping_cart_items_ids = reader.readLine().split(",");
                for (String item_id : shopping_cart_items_ids) {
                    if (!item_id.isEmpty()) {
                        String id_quantity[] = item_id.split(":");
                        Item item = system.get_item_by_id(Integer.parseInt(id_quantity[0]));
                        item.set_quantity(Double.parseDouble(id_quantity[1]));
                        user.get_shopping_cart().add_item(item, Double.parseDouble(id_quantity[1]));
                    }
                }

                String[] orders_ids = reader.readLine().split(",");
                for (String order_id : orders_ids) {
                    if (!order_id.isEmpty()) {
                        Order order = system.get_order_by_id(Integer.parseInt(order_id));
                        user.add_order(order);
                    }
                }
                system.add_user(user);
            }
            reader.close();

            // load categories
            reader = new BufferedReader(new FileReader(CATEGORIES_FILE));
            while ((line = reader.readLine()) != null) {
                String category_name = line;

                String[] items_ids = reader.readLine().split(",");
                ArrayList<Item> items = new ArrayList<Item>();
                for (int i = 0; i < items_ids.length; i++) {
                    Item item = system.get_item_by_id(Integer.parseInt(items_ids[i]));
                    items.add(item);
                }
                Category category = new Category(category_name, items);
                system.add_category(category);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading data");
        }
    }

    // =======================================================================================================

    /**
     * basic encrypt and decrypt detrmined by key
     * 
     * @param str
     * @param key
     * @return encrypted string if key postive, decrypted string if key negative
     */
    public static String encrypt_decrypt(String str, int key) {
        StringBuilder result = new StringBuilder(); // mutable string which can be changed unlike String class
        for (int i = 0; i < str.length(); i++) {
            char ch = (char) (str.charAt(i) + key);
            result.append(ch);
        }
        return result.toString();
    }

}