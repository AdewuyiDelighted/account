package account;

public class InvalidWithdrawalAmount extends RuntimeException {
    public InvalidWithdrawalAmount(String message){
        super(message);
    }
}
