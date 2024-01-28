package ex04.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String err) {
        super(err);
    }


}
