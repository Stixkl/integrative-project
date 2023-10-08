package exceptions;

public class IlegalIndexSwitch extends Exception{

    public IlegalIndexSwitch() {
        super("Ilegal index switch");
    }

    public String getMessage() {
        return super.getMessage();
    }
}
