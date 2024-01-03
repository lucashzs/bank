import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank extends User {
    private List<User> users = new ArrayList<>();

    public void apresentation() {
        System.out.println("-------------------------");
        System.out.println("  Welcome to Coins Bank  ");
        System.out.println("  The bank made for you  ");
        System.out.println("-------------------------");
    }


    public void log() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============");
        System.out.println("Enter your Login!");
        System.out.println("=============");

        System.out.print("What is your email? ");
        String email = scanner.nextLine();

        System.out.print("What is you password? ");
        String password = scanner.nextLine();


        users.forEach(user -> {
            if (user.email.equalsIgnoreCase(email) && user.password.equalsIgnoreCase(password)) {
                System.out.println("Login Successfully!");
                // fazer puxar a logica do banco
                Bank k = new Bank();
                k.logic();
            } else {
                System.out.println("Failed login!");
            }
        });
    }

    private double money;
    private Historic hist = new Historic();

    public Bank(String name, int cpf, String email, String password) {
        super(name, cpf, email, password);
    }

    public Bank() {
        super();
    }

    // logica depositar

    public void deposit(double value) {
        money += value;
        hist.out("Deposit $" + money + " Now you have: $" + money);
    }

    // logica de saque

    public boolean withDraw(double value) {
        if (money < value) {
            hist.out("WithDraw $" + money + " Your current balance is: $" + money);
            return false;
        } else {
            money -= value;
            hist.out("Now you have: $" + money);
            return true;
        }
    }

    // logica usuario depositar/sacar/sair do banco

    public void logic() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("What operation do you want to perform?  Withdraw, Deposit, Exit ");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("deposit")) {
                System.out.print("What amount do you want to deposit? ");
                double value = scanner.nextDouble();
                deposit(value);
            } else if (operation.equalsIgnoreCase("withdraw")) {
                System.out.print("What amount do you want to withdraw? ");
                double value = scanner.nextDouble();
                if (!withDraw(value)) {
                    System.out.println("It was not possible to withdraw this amount!");
                }
            } else if (operation.equalsIgnoreCase("exit")) {
                System.out.println("________________________________");
                System.out.println("Account " + this.name + " " + "It has $" + money);
                break;
            } else {
                System.out.println("Enter a valid operation!");
            }
            scanner = new Scanner(System.in);
        }
    }
}

