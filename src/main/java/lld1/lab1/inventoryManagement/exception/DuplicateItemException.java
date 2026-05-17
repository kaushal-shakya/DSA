package lld1.lab1.inventoryManagement.exception;

public class DuplicateItemException extends Exception {
    public DuplicateItemException(String message) {
        super(message);
    }

    public DuplicateItemException(Throwable cause) {
        super(cause);
    }
}
