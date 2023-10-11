package exceptions;

public class ListIsNullException extends Exception{

    public ListIsNullException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}