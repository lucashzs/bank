import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var bank = new Bank();

        while(true) {
            System.out.print("[R] - Register | ");
            System.out.print("[L] - Login | ");

            var response = scanner.nextLine();

            if (response.equalsIgnoreCase("R")) {
                bank.registerUser();
            } else if (response.equalsIgnoreCase("L")) {
                bank.loginUser();
            } else {

            }
        }
    }
}