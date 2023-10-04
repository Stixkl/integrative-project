package exceptions;

public class ListIsNullException extends Exception{

    public ListIsNullException(){
        super("The list is null");

    }
    public String getMessage(){
        return super.getMessage();
    }
}
