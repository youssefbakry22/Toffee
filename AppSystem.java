import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * This class interacts with other classes to carry out its responsibilities.
 * 
 * @author Youssef Bakry
 * @version 1.0
 * @since 2023-5-7
 */
public class AppSystem {
    private ArrayList<User> users;
    private ArrayList<Item> items;
    private ArrayList<Category> categories;
    private ArrayList<Order> orders;
    private Storage storage;
    private int otp;

    /**
     * This is the constructor of the class.
     */
    public AppSystem() {
        this.users = new ArrayList<User>();
        this.items = new ArrayList<Item>();
        this.categories = new ArrayList<Category>();
        this.orders = new ArrayList<Order>();
        this.storage = new Storage();
    }

    /**
     * This method returns the item with the given name.
     * 
     * @param name
     * @return Item
     */
    public Item get_item(String name) {
        for (Item item : items) {
            if (item.get_name().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * This method returns the item with the given id.
     * 
     * @param id
     * @return Item
     */
    public Item get_item_by_id(int id) {
        for (Item item : items) {
            if (item.get_id() == id) {
                return item;
            }
        }
        return null;
    }

    /**
     * This method returns the order with the given id.
     * 
     * @param name
     * @return Order
     */
    public Order get_order_by_id(int id) {
        for (Order order : orders) {
            if (order.get_id() == id) {
                return order;
            }
        }
        return null;
    }

    /**
     * This method returns the user with the given user name.
     * 
     * @param user_name
     * @return User
     */
    public User get_user(String user_name) {
        for (User user : users) {
            if (user.get_user_name().equals(user_name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * This method checks if the given user name exists.
     * 
     * @param user_name
     * @return true if the user name exists, false otherwise.
     */
    public boolean exists_user_name(String user_name) {
        for (User user : users) {
            if (user.get_user_name().equals(user_name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if the given email exists.
     * 
     * @param email
     * @return true if the email exists, false otherwise.
     */
    public boolean exists_email(String email) {
        for (User user : users) {
            if (user.get_email().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if the item with given id exists.
     * 
     * @param id
     * @return true if the item exists, false otherwise.
     */
    public boolean exists_item(int id) {
        for (Item item : items) {
            if (item.get_id() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if the item with given name exists.
     * 
     * @param name
     * @return true if the item exists, false otherwise.
     */
    public boolean exists_item(String name) {
        for (Item item : items) {
            if (item.get_name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method adds a new user to the system.
     * 
     * @param new_user
     */
    public void add_user(User new_user) {
        this.users.add(new_user);
    }

    /**
     * This method adds a new item to the system.
     * 
     * @param item
     */
    public void add_item(Item item) {
        this.items.add(item);
    }

    /**
     * This method adds a new category to the system.
     * 
     * @param category
     */
    public void add_category(Category category) {
        this.categories.add(category);
    }

    /**
     * This method adds a new order to the system.
     * 
     * @param order
     */
    public void add_order(Order order) {
        this.orders.add(order);
    }

    /**
     * This method modifies the password of the user with the given user name.
     * 
     * @param user_name
     * @param new_password
     */
    public void modify_user(String user_name, String new_password) {
        for (User user : users) {
            if (user.get_user_name().equals(user_name)) {
                user.set_password(new_password);
                break;
            }
        }
    }

    /**
     * This method validates the credentials of the user by checking if the user
     * name and password are correct.
     * 
     * @param user_name
     * @param password
     * @return true if the credentials are correct, false otherwise.
     */
    public boolean validate_credentials(String user_name, String password) {
        for (User user : users) {
            if (user.get_user_name().equals(user_name) &&
                    user.get_password().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this method creates a new order with the given items.
     * 
     * @param items
     * @return Order after adding it to the system and setting its id and status.
     */
    public Order make_order(ArrayList<Item> items) {
        int order_id = orders.size() + 1;
        Order order = new Order(order_id, "pending", items);
        this.orders.add(order);
        return order;
    }

    /**
     * This method updates the status of the order with the given id.
     * 
     * @param order_id
     * @param status
     */
    public void update_order_status(int order_id, String status) {
        for (Order order : orders) {
            if (order.get_id() == order_id) {
                order.set_status(status);
                break;
            }
        }
    }

    /**
     * This method creates the catalog from categories.
     * 
     * @return Catalog
     */
    public Catalog create_catalog() {
        Catalog catalog = new Catalog(categories);
        return catalog;
    }

    /**
     * This method is used to load the data from the storage.
     */
    public void load_system_data() {
        storage.load_data(this);
    }

    /**
     * This method is used to save the data to the storage.
     */
    public void save_system_data() {
        storage.save_data(users, orders, items, categories);
    }

    /**
     * This method is used to send an OTP to the user with the given email.
     * 
     * @param email
     */
    public void send_OTP_email(String email) {
        otp = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "toffe.store.1@gmail.com";
        String password = "uhmtzbtwvvgeuhuf";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            String to = email;
            String subject = "OTP Verification";
            String message = "Your OTP is " + this.otp;

            // Create the email message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(message);

            Transport.send(msg);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to send an OTP to the user with the given phone number.
     * 
     * @param phone
     */
    public void send_OTP_phone(String phone) {
        otp = 1234;
    }

    /**
     * This method is used to verify the OTP sent by the system.
     * 
     * @param otp entered by the user.
     * @return true if the OTP is correct, false otherwise.
     */
    public boolean verify_OTP(int otp) {
        return this.otp == otp;
    }
}