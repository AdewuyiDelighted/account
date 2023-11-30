package account;

public class InvalidWithdrawalAmountException extends RuntimeException {
    public InvalidWithdrawalAmountException(String message){

        super(message);
    }
}
