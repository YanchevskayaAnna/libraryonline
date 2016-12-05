package exception;

public class TableIsEmptyException extends Exception {

    public TableIsEmptyException() {
    }

    public TableIsEmptyException(String message) {
        super(message);
    }
}
