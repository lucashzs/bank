import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);

    protected String name;
    protected int cpf;
    protected String email;
    protected String password;

    public User(String name, int cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
    }

    public User() {
    }

    // logica de criar um novo user
    public void questionUser() {
            System.out.print("What do you want to do, register or log in? ");
            var rl = scanner.nextLine();

            if (rl.equalsIgnoreCase("register")) {
                System.out.print("What is your name? ");
                name = scanner.nextLine();

                System.out.print("Enter your cpf: ");
                var cpf1 = scanner.nextLine();
                cpf = Integer.parseInt(cpf1);

                System.out.print("Enter your email: ");
                email = scanner.nextLine();

                System.out.print("Enter your password: ");
                password = scanner.nextLine();

            } else if (rl.equalsIgnoreCase("log in")) {
                Bank b = new Bank();
                b.log();
            }
            while (rl.isBlank() || (!rl.equalsIgnoreCase("register") && !rl.equalsIgnoreCase("log in"))) {
                System.out.print("Choose one of the previous options! ");
                rl = scanner.nextLine();
            }
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}