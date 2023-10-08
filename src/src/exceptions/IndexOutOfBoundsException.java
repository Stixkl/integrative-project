package exceptions;

public class IndexOutOfBoundsException extends Exception {
    public IndexOutOfBoundsException() {
        super("Index out of bounds");
    }
    public String getMessage() {
        return super.getMessage();
    }
}
