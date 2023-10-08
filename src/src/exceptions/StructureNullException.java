package exceptions;

public class StructureNullException extends Exception {
    public StructureNullException() {
        super("The structure is null");
    }
    public String getMessage() {
        return super.getMessage();
    }
}

