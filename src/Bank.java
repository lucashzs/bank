import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<User> users = new ArrayList<>();
    private double totalMoney = 0f;
    private Historic hist = new Historic();

    public void apresentation() {
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
    }

    public boolean loginUser() {
        var scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        var email = scanner.nextLine();

        System.out.print("Enter your password: ");
        var password = scanner.nextLine();

        var response = false;

        for (User user : this.users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                response = true;
            }
        }

        return response;
    }

    // logica depositar
//    public void deposit(double value) {
//        money += value;
//        hist.out("Deposit $" + money + " Now you have: $" + money);
//    }
//
//    // logica de saque
//    public boolean withDraw(double value) {
//        if (money < value) {
//            hist.out("WithDraw $" + money + " Your current balance is: $" + money);
//            return false;
//        } else {
//            money -= value;
//            hist.out("Now you have: $" + money);
//            return true;
//        }
//    }
//
//    // logica usuario depositar/sacar/sair do banco
//    public void logic() {
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("What operation do you want to perform?  Withdraw, Deposit, Exit ");
//            String operation = scanner.nextLine();
//
//            if (operation.equalsIgnoreCase("deposit")) {
//                System.out.print("What amount do you want to deposit? ");
//                double value = scanner.nextDouble();
//                deposit(value);
//            } else if (operation.equalsIgnoreCase("withdraw")) {
//                System.out.print("What amount do you want to withdraw? ");
//                double value = scanner.nextDouble();
//                if (!withDraw(value)) {
//                    System.out.println("It was not possible to withdraw this amount!");
//                }
//            } else if (operation.equalsIgnoreCase("exit")) {
//                System.out.println("________________________________");
//                System.out.println("Account " + this.name + " " + "It has $" + money);
//                break;
//            } else {
//                System.out.println("Enter a valid operation!");
//            }
//            scanner = new Scanner(System.in);
//        }
//    }
}

