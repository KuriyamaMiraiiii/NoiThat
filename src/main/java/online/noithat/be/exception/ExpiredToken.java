package online.noithat.be.exception;

public class ExpiredToken extends RuntimeException{
    public ExpiredToken(String message){
        super(message);
    }
}
