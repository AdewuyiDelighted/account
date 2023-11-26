public class Account {
    private int balance;

    public void Account(String userName,String pin){

    }

    public void deposit(int amount){
       this.balance = amount;

    }
    public int checkBalance(){
        return balance;
    }

    private static int validateDeposit(int amount){
        if(amount < 0)
        throw new InvalidAmountException("Invalid amount");

    }
}
