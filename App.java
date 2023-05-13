import java.util.Scanner;
import java.io.Console;

/**
 * This class represents the interface through which users will interact with
 * the system.
 * 
 * @author Youssef Bakry
 * @version 1.0
 * @since 2023-5-7
 */
public class App {
    private AppSystem system;
    private User user;
    Scanner sc = new Scanner(System.in);
    Console console = System.console();

    /**
     * constructor of the class
     */
    App() {
        system = new AppSystem(); // create a new system
        system.load_system_data(); // load data from files to the system
    }

    /**
     * the intial point of the program
     */
    public void start() {
        clear_screen();
        String choice = main_menu();

        switch (choice) {
            case "1":
                if (user_login()) {
                    wait(3);
                    go_shopping();
                } else {
                    start();
                }
                break;

            case "2":
                user_registration();
                wait(3);
                go_shopping();
                break;

            case "3":
                system.save_system_data();
                print("Thank you for using Toffee store!");
                print("__________________________________________________________________\n");
                System.exit(0); // exit the program
                break;

            default:
                print("Invalid choice!");
                print("__________________________________________________________________");
                wait(3);
                start();
                break;
        }
    }

    /**
     * main menu or home page
     * 
     * @return String this is the choice of the user
     */
    public String main_menu() {
        print("                     Welcome to Toffee store! ");
        print("__________________________________________________________________\n");
        print("1. Login");
        print("2. Register");
        print("3. Exit");
        print("Enter your choice: ");

        String choice = sc.next();
        sc.nextLine(); // consume the rest of the line to avoid skipping nextLine()
        print("__________________________________________________________________\n");
        return choice;
    }

    /**
     * shopping menu
     * 
     * @return String this is the choice of the user
     */
    // shopping menu
    public String shopping_menu() {
        print("                           Toffee Store  ");
        print("__________________________________________________________________\n");
        print("1. Search for an item");
        print("2. View catalog");
        print("3. View my cart");
        print("4. Logout");
        print("Enter your choice: ");

        String choice = sc.next();
        sc.nextLine(); // consume the rest of the line to avoid skipping nextLine()
        print("__________________________________________________________________\n");
        return choice;
    }

    /**
     * this method is used to move user to the shopping page after login
     */
    public void go_shopping() {
        clear_screen();
        String choice = shopping_menu();

        switch (choice) {
            case "1":
                clear_screen();
                print("                           Search Page  ");
                print("__________________________________________________________________\n");
                print("Enter the name of the item you want to search for: ");
                String item_name = sc.nextLine();

                if (system.exists_item(item_name)) {
                    Item item = system.get_item(item_name);
                    print(item.toString());

                    print("Do you want to add this item to your cart? (y/n)");
                    String ans = sc.next();

                    if (ans.equals("y")) {
                        print("\nEnter the quantity of the item you want to add: ");
                        Double quantity = sc.nextDouble();
                        user.get_shopping_cart().add_item(item, quantity);
                        print("\nItem added to cart successfully!");
                    }

                } else {
                    print("\nItem not found!");
                }
                print("__________________________________________________________________");
                wait(3);
                go_shopping();
                break;

            case "2":
                clear_screen();
                print("                              Catalog  ");
                print("__________________________________________________________________\n");
                Catalog catalog = system.create_catalog();
                catalog.display_items_inside_categories();

                print("Do you want to add item(s) to your cart? (y/n)");
                String ans = sc.next();

                if (ans.equals("y")) {
                    print("\nEnter number of items you want to add: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        print("\nEnter the id of item " + (i + 1) + ": ");
                        int item_id = sc.nextInt();

                        if (system.exists_item(item_id)) {
                            Item item = system.get_item_by_id(item_id);
                            print("\nEnter the quantity of the item you want to add: ");
                            Double quantity = sc.nextDouble();
                            user.get_shopping_cart().add_item(item, quantity);
                            print("\nItem added to cart successfully!");
                        } else {
                            print("\nItem not found!");
                        }
                    }
                }
                print("__________________________________________________________________");
                wait(3);
                go_shopping();
                break;

            case "3":
                if (user.get_shopping_cart().is_empty()) {
                    print("Your cart is empty!");

                } else {
                    clear_screen();
                    print("                            My Cart  ");
                    print("__________________________________________________________________\n");
                    user.view_shopping_cart();

                    print("\nDo you want to make order? (y/n)");
                    String ans2 = sc.next();
                    if (ans2.equals("y")) {
                        Order order = system.make_order(user.get_shopping_cart().get_items());
                        user.add_order(order);

                        print("\nTotal price: " + order.get_total_price() + " EGP");
                        print("Shipping fees: 50 EGP");
                        print("Sub Total: "
                                + (order.get_total_price() + 50) + " EGP");

                        print("To be paid on delivery: ");
                        print("\nDo you want to checkout now? (y/n)");
                        String ans3 = sc.next();

                        if (ans3.equals("y")) {
                            user.checkout(order.get_id());
                            system.update_order_status(order.get_id(), "placed");
                            print("\nOrder placed successfully!");
                        }
                    }
                }
                print("__________________________________________________________________");
                wait(3);
                go_shopping();
                break;

            case "4":
                print("Redirecting to home page in 3 seconds...");
                wait(3);
                start();
                break;

            default:
                print("Invalid choice!");
                print("__________________________________________________________________");
                wait(3);
                go_shopping();
                break;
        }
    }

    /**
     * this method is used to login the user to the system
     * 
     * @return boolean
     */
    // user login
    public boolean user_login() {
        int n_tries = 3;

        while (n_tries > 0) {
            clear_screen();
            print("                              Login Page  ");
            print("__________________________________________________________________\n");
            print("Enter your name:");
            String user_name = sc.next();
            String password;

            if (console == null) {
                // get password not hidden because cant find the console
                print("\nEnter your password:");
                password = sc.next();
            } else {
                // get password hidden
                password = new String(console.readPassword("\nEnter your password:\n"));
            }
            print("__________________________________________________________________\n");

            if (system.validate_credentials(user_name, password)) {
                print("Login successful!");
                print("Now you can go shopping!");

                this.user = system.get_user(user_name);
                return true;

            } else {
                n_tries--;
                print("Invalid credentials! " + n_tries + " tries left.");

                print("Forget password? (y/n)");
                String forget_password = sc.next();

                if (forget_password.equals("y")) {
                    forget_password(user_name);
                    return true;
                }
            }

        }
        print("__________________________________________________________________\n");
        print("You have exceeded the number of tries!");
        print("Redirecting to home page in 3 seconds...");
        wait(3);
        return false;
    }

    /**
     * this method is used register the user to the system
     */
    public void user_registration() {
        clear_screen();
        print("                             Registration Page  ");
        print("__________________________________________________________________\n");
        String user_name = null, email = null, password = null, address = null;

        print("Enter your name:");
        while (true) {
            user_name = sc.nextLine();
            if (system.exists_user_name(user_name)) {
                print("\nUser already exists!");
                print("Try another username:");

            } else if (user_name.matches(".*\\s.*")) { // check if username contains spaces
                print("\nUsername should not contain spaces!");
                print("Try another username:");

            } else {
                break;
            }
        }

        print("\nEnter your email:");
        while (true) {
            email = sc.next();
            if (system.exists_email(email)) {
                print("\nEmail already exists!");
                print("Enter another email: ");
            } else {
                String email_format = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

                if (email.matches(email_format)) {
                    break;
                } else {
                    print("\nInvalid email format!");
                    print("Enter a valid email: ");
                }
            }
        }

        while (true) {
            if (console == null) {
                // get password not hidden because cant find the console
                print("\nEnter your password:");
                password = sc.next();
            } else {
                // get password hidden
                password = new String(console.readPassword("\nEnter your password:\n"));
            }
            if (password.length() < 8) {
                print("\bPassword must be at least 8 characters long!");
            } else {
                break;
            }
        }

        print("\nEnter your address:");
        address = sc.next();

        system.send_OTP_email(email);
        int otp_tries = 3;
        while (otp_tries > 0) {
            print("\nEnter the OTP sent to your email:");
            int otp = sc.nextInt();

            if (system.verify_OTP(otp)) {
                print("__________________________________________________________________\n");

                this.user = new User(user_name, email, password, address);
                system.add_user(user);

                print("Registration successful!");
                break;

            } else {
                otp_tries--;
                print("Invalid OTP! " + otp_tries + " tries left.");
            }
        }
        print("Redirecting to home page in 3 seconds...");
        wait(3);
        start();
    }

    /**
     * reset password if user forgets password
     * 
     * @param user_name
     */
    public void forget_password(String user_name) {
        int otp_tries = 3;

        print("\nEnter your email:");
        String email = sc.next();

        if (system.exists_email(email)) {
            system.send_OTP_email(email);
        } else {
            print("\nEmail not registered!");
            print("Redirecting to home page in 3 seconds...");
            wait(3);
            start(); // redirect to home page
        }

        while (otp_tries > 0) {
            print("\nEnter the OTP sent to your email:");
            int otp = sc.nextInt();
            String new_password;

            if (system.verify_OTP(otp)) {
                if (console == null) {
                    // get password not hidden because cant find the console
                    print("\nEnter your new password:");
                    new_password = sc.next();
                } else {
                    // get password hidden
                    new_password = new String(console.readPassword("\nEnter your new password:\n"));
                }
                system.modify_user(user_name, new_password);
                print("\nPassword changed successfully!");
                print("__________________________________________________________________\n");

                break;
            } else {
                otp_tries--;
                print("Invalid OTP! " + otp_tries + " tries left.");
            }
        }
    }

    /**
     * wait for n seconds before doing something
     * 
     * @param seconds
     */
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * clear screen in terminal
     */
    public void clear_screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * shortcut for System.out.println()
     * 
     * @param s
     */
    // print
    public void print(String s) {
        System.out.println(s);
    }

}