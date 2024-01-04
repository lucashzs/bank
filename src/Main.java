import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var bank = new Bank();
        bank.presentation();

        while (true) {
            if (bank.loggedUser == null) {
                System.out.print("[R] - Register | ");
                System.out.print("[L] - Login | ");

            } else {
                System.out.println("[D] - Deposit | ");
                System.out.println("[W] - Withdraw | ");
                System.out.println("[B] - See Balance | ");
                System.out.println("[E] - Exit | ");
            }

            var response = scanner.nextLine();

            if (response.equalsIgnoreCase("R")) {
                bank.registerUser();
            } else if (response.equalsIgnoreCase("L")) {
                var userResponse = bank.loginUser();
                if (userResponse != null) {
                    userResponse.setLogged(true);
                    bank.loggedUser = userResponse;
                } else {
                    System.out.println("Try a valid email...");
                }
            } else if (response.equalsIgnoreCase("D")) {
                bank.deposit();
            } else if (response.equalsIgnoreCase("W")) {
                bank.withdraw();
            } else if (response.equalsIgnoreCase("B")) {
                bank.seeBalance();
            } else if (response.equalsIgnoreCase("E")){
                bank.exit();
            } else {
                System.out.println("Choose a valid option");
            }
        }
    }
}