package ex03.exception;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(String err) {
        super(err);
    }
}
