package lld1.lab1.inventoryManagement.exception;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }

    public InvalidQuantityException(Throwable cause) {
        super(cause);
    }
}
