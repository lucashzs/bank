import java.util.Scanner;

public class User {


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

//    // logica de criar um novo user
//    public void questionUser() {
//
//
//            if (rl.equalsIgnoreCase("register")) {
//
//
//            } else if (rl.equalsIgnoreCase("log in")) {
//                Bank b = new Bank();
//                b.log();
//            }
//            while (rl.isBlank() || (!rl.equalsIgnoreCase("register") && !rl.equalsIgnoreCase("log in"))) {
//                System.out.print("Choose one of the previous options! ");
//                rl = scanner.nextLine();
//            }
//        }

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