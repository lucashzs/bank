import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<User> users = new ArrayList<>();
    public User loggedUser = null;
    private Historic hist = new Historic();

    public void presentation() {
        System.out.println("-------------------------");
        System.out.println("  Welcome to Coins Bank  ");
        System.out.println("  The bank made for you  ");
        System.out.println("-------------------------");
    }

    public void registerUser() {
        var scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        var name = scanner.nextLine();

        System.out.print("Enter your cpf: ");
        var cpf = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter your email: ");
        var email = scanner.nextLine();

        System.out.print("Enter your password: ");
        var password = scanner.nextLine();

        var newUser = new User(name, cpf, email, password);

        this.users.add(newUser);

        var userResponse = loginUser(email, password);
        if (userResponse != null) {
            userResponse.setLogged(true);
            this.loggedUser = userResponse;
        }
    }

    //Logic for checking user emails/passwords
    public User verifyCorrectUser(String email, String password) {
        User response = null;

        for (User user : this.users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                response = user;
            }
        }
        return response;
    }

    //Login logic after registering
    public User loginUser(String email, String password) {

        return verifyCorrectUser(email, password);
    }

    //Logic of logging in directly after a user is already logged in
    public User loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        var email = scanner.nextLine();

        System.out.print("Enter your password: ");
        var password = scanner.nextLine();

        return verifyCorrectUser(email, password);
    }

    //Deposit logic
    public void deposit() {
        var scanner = new Scanner(System.in);
        System.out.print("How many do you want to deposit? ");
        var value = scanner.nextDouble();

        this.users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(this.loggedUser.getEmail())) {
                user.setBalance(user.getBalance() + value);
                this.loggedUser = user;
            }
        });

        hist.out("Deposit $" + value + " Now you have: $" + loggedUser.getBalance());
    }

    //Withdrawal logic
    public void withdraw() {
        var scanner = new Scanner(System.in);
        System.out.print("How many do you want to withdraw? ");
        var value = scanner.nextDouble();

        if (this.loggedUser.getBalance() < value) {
            hist.out("Withdraw Error $" + value + " You do not have enough balance!");
        } else {
            this.users.forEach((user) -> {
                if (user.getEmail().equalsIgnoreCase(this.loggedUser.getEmail())) {
                    user.setBalance(user.getBalance() - value);
                    this.loggedUser = user;
                }
            });
            hist.out("Withdraw $" + value + " Now you have: $" + loggedUser.getBalance());
        }
    }

    public void exit() {
        this.users.forEach((user) -> {
            user.setLogged(false);
        });
        this.loggedUser = null;
    }

    public void seeBalance() {
        hist.out("Balance $" + this.loggedUser.getBalance());
    }
}