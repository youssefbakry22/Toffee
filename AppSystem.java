import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class AppSystem {
    private ArrayList<LoggedInUser> users;
    private ArrayList<Item> items;
    private ArrayList<Category> categories;
    private ArrayList<Order> orders;
    private Storage storage;
    private int otp;

    public AppSystem() {
        this.users = new ArrayList<LoggedInUser>();
        this.items = new ArrayList<Item>();
        this.categories = new ArrayList<Category>();
        this.orders = new ArrayList<Order>();
        this.storage = new Storage();
    }

    public Item get_item(String name) {
        for (Item item : items) {
            if (item.get_name().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Item get_item_by_id(int id) {
        for (Item item : items) {
            if (item.get_id() == id) {
                return item;
            }
        }
        return null;
    }

    public Order get_order_by_id(int id) {
        for (Order order : orders) {
            if (order.get_id() == id) {
                return order;
            }
        }
        return null;
    }

    public LoggedInUser get_user(String user_name) {
        for (LoggedInUser user : users) {
            if (user.get_user_name().equals(user_name)) {
                return user;
            }
        }
        return null;
    }

    public boolean exists_user_name(String user_name) {
        for (LoggedInUser user : users) {
            if (user.get_user_name().equals(user_name)) {
                return true;
            }
        }
        return false;
    }

    public boolean exists_email(String email) {
        for (LoggedInUser user : users) {
            if (user.get_email().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean exists_item(int id) {
        for (Item item : items) {
            if (item.get_id() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean exists_item(String name) {
        for (Item item : items) {
            if (item.get_name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void add_user(LoggedInUser new_user) {
        this.users.add(new_user);
    }

    public void add_item(Item item) {
        this.items.add(item);
    }

    public void add_category(Category category) {
        this.categories.add(category);
    }

    public void add_order(Order order) {
        this.orders.add(order);
    }

    public void modify_user(String user_name, String new_password) {
        for (LoggedInUser user : users) {
            if (user.get_user_name().equals(user_name)) {
                user.set_password(new_password);
                break;
            }
        }
    }

    public boolean validate_credentials(String user_name, String password) {
        for (LoggedInUser user : users) {
            if (user.get_user_name().equals(user_name) &&
                    user.get_password().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Order make_order(ArrayList<Item> items) {
        int order_id = orders.size() + 1;
        Order order = new Order(order_id, "pending", items);
        this.orders.add(order);
        return order;
    }

    public void update_order_status(int order_id, String status) {
        for (Order order : orders) {
            if (order.get_id() == order_id) {
                order.set_status(status);
                break;
            }
        }
    }

    public Catalog create_catalog() {
        Catalog catalog = new Catalog(categories);
        return catalog;
    }

    public void load_system_data() {
        storage.load_data(this);
    }

    public void save_system_data() {
        storage.save_data(users, orders, items, categories);
    }

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

    public void send_OTP_phone(String phone) {
        otp = 1234;
    }

    public boolean verify_OTP(int otp) {
        return this.otp == otp;
    }
}