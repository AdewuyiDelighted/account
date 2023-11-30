package account;

public class Account {
    private String username;
    private int balance;
    private String pin;
    private String number;

    public Account(String userName, String accountNumber, String pin) {
        this.username = userName;
        this.pin = pin;
        number = accountNumber;

    }

    public void deposit(int amount) {
        validateDeposit(amount);
        this.balance += amount;
    }

    public int checkBalance(String pin) {
        validatePin(pin);
        return balance;
    }

    public void withdraw(int amount, String pin) {
        validateWithdrawal(amount);
        validatePin(pin);
        this.balance -= amount;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return number;
    }

    public String getName() {
        return username;
    }


    private void validateDeposit(int amount) {
        if (amount < 0) throw new InvalidAmountException("Invalid amount");
    }

    private void validateWithdrawal(int amount) {
        if (amount > balance) throw new InvalidWithdrawalAmountException("Insufficient fund");


    }

    private void validatePin(String pin) {
        if (!this.pin.equals(pin)) throw new IncorrectPasswordException("Incorrect pin");

    }

    @Override
    public String toString() {
        return String.format("""
                Customer name : %s
                Customer Account number : %s
                Customer balance : %s
                """, getName(), getAccountNumber(), checkBalance(pin));


    }


}
