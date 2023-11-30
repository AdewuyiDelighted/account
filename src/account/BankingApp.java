package account;

import java.util.ArrayList;

public class BankingApp {
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();
    private int totalNumberOfAccount = 0;

    public BankingApp() {

    }

    public Account createAccount(String firstName, String secondName, String pin) {
        totalNumberOfAccount++;
        String name = generateName(firstName, secondName);
        String accountNumber = generateAccountNumber();
        Account account = new Account(name, accountNumber, pin);
        accounts.add(account);
        return account;
    }

    private String generateAccountNumber() {
        return totalNumberOfAccount + "";
    }

    public int getNumberOfAccount() {
        return totalNumberOfAccount;
    }


    private String generateName(String firstName, String secondName) {
        return firstName + " " + secondName;
    }

    public void deposit(String accountNumber, int amount) {
        Account account = findAccount(accountNumber);
        account.deposit(amount);

    }

    public Account findAccount(String number) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                return account;
            }
        }
        return null;
    }

    public int checkBalance(String accountNumber,String password) {
        Account account = findAccount(accountNumber);
        return account.checkBalance(password);
    }

    public void withdraw(String accountNumber,String password,int amount){
        Account account = findAccount(accountNumber);
        account.withdraw(amount,password);
    }

    public void transfer(String senderAccountNumber,String receiverAccountNumber,String password,int amount){
        Account account = findAccount(senderAccountNumber);
        account.withdraw(amount,password);
        Account account1 = findAccount(receiverAccountNumber);
        account1.deposit(amount);
    }
}
