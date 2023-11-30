package account;

import java.util.Scanner;

public class AccountMainFunction {
    static BankingApp bankingApp = new BankingApp();
    static MultiThread thread = new MultiThread();
    public static void mainMenu() {
        display();
        String userInput = input("Enter a number");
        switch (userInput) {
            case "1" -> createAccount();
            case "2" -> deposit();
            case "3" -> withdraw();
            case "4" -> transfer();
            case "5" -> checkBalance();
            case "6" -> exit();
            default  -> display();
        }
    }


    public static String display() {
        System.out.println("""
                 ==========================================
                 Welcome to OpeShort Bank                  =
                 Enter 1 to create an account              =
                 Enter 2 to deposit                        =
                 Enter 3 to withdraw                       =
                 Enter 4 to transfer                       =
                 Enter 5 to check balance                  =
                 Enter 6 to exit                           =
                 ===========================================
                """);
        return null;
    }


    public static void createAccount() {
        String firstname = input("Enter your Firstname");
        String secondName = input("Enter your second name");
        String password = input("Enter your password");
        Account account = bankingApp.createAccount(firstname, secondName, password);

        thread.run();
        System.out.println(account.toString());
        thread.run();
        mainMenu();

    }

    public static void deposit() {
        String accountNumber = input("Enter you account number");
        int amount = Integer.parseInt(input("Enter the amount"));
        bankingApp.deposit(accountNumber, amount);
        Account account = bankingApp.findAccount(accountNumber);
        thread.run();
        System.out.println(account.toString());
        thread.run();
        mainMenu();
    }

    public static void withdraw() {
        String accountNumber = input("Enter your account Number");
        String password = input("Enter your password");
        int amount = Integer.parseInt(input("Enter amount"));
        bankingApp.withdraw(accountNumber, password, amount);
        Account account = bankingApp.findAccount(accountNumber);
        thread.run();
        System.out.println(account.toString());
        thread.run();
        mainMenu();
    }

    public static void transfer() {
        String senderAccountNumber = input("Enter the account number of sender");
        String receiverAccountNumber = input("Enter the receiver account number");
        int amount = Integer.parseInt(input("Enter amount you want to transfer"));
        String senderPassword = input("Enter the password of sender");
        bankingApp.transfer(senderAccountNumber, receiverAccountNumber, senderPassword, amount);
        Account account = bankingApp.findAccount(senderAccountNumber);
        Account account2 = bankingApp.findAccount(receiverAccountNumber);
        thread.run();
        System.out.println(account.toString());
        thread.run();
        thread.run();
        System.out.println(account2.toString());
        thread.run();
        mainMenu();
    }

    public static void checkBalance() {
        String accountNumber = input("Enter you account number");
        String password = input("Enter your password");
        bankingApp.checkBalance(accountNumber, password);
        Account account = bankingApp.findAccount(accountNumber);
        thread.run();
        System.out.println(account.toString());
        thread.run();
        mainMenu();
    }

    public static void exit() {
        display();
    }

    private static String input(String message) {
        Scanner scanner = new Scanner(System.in);
        print(message);
        String answer = scanner.nextLine();
        return answer;
    }

    private static void print(String message) {
        System.out.println(message);
    }
}

