package account;

public class IncorrectPasswordException extends RuntimeException {
    IncorrectPasswordException(String message){
        super(message);
    }

}
