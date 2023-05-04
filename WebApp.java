import java.util.Scanner;

public class WebApp {
    private AppSystem system;

    WebApp() {
        this.system = new AppSystem();
    }

    public void start() {
        int choice = this.main_menu();

        switch (choice) {
            case 1:
                this.user_login();
                break;

            case 2:
                System.out.println("Enter your name:");
                break;

            case 3:
                System.out.println("Thank you for using Toffee store!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

    }

    public int main_menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------- Welcome to Toffee store! --------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");

        int choice = sc.nextInt();
        System.out.println("-----------------------------------------------------------------");

        // sc.close();
        return choice;
    }

    public void user_login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String user_name = sc.next();

        System.out.println("Enter your password:");
        String password = sc.next();

        if (this.system.validate_credentials(user_name, password))
            System.out.println("Login successful!");
        else
            System.out.println("Invalid credentials!");

        sc.close();
    }

    public void user_regestration() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String user_name = sc.next();
        System.out.println("Enter your email:");
        String email = sc.next();
        System.out.println("Enter your password:");
        String password = sc.next();
        System.out.println("Enter your address:");
        String address = sc.next();

        this.system.send_OTP_email(email);
        System.out.println("Enter the OTP sent to your email:");
        int otp = sc.nextInt();
        if (this.system.verify_OTP(otp))
            System.out.println("Registration successful!");
        else
            System.out.println("Invalid OTP!");

        LoggedInUser user = new LoggedInUser(user_name, email, password, address);
        this.system.add_user(user);

        sc.close();
    }
}