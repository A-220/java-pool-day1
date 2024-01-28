package ex04.exception;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(String err) {
        super(err);
    }
}
