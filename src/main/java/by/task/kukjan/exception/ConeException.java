package by.task.kukjan.exception;

public class ConeException extends Exception{
    public ConeException(){
        super();
    }

    public ConeException(String message){
        super(message);
    }

    public ConeException(Exception e) {
        super(e);
    }

    public ConeException(String message, Exception e) {
        super(message, e);
    }
}
