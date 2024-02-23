package online.noithat.be.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthenticationHandlerException {
    @ExceptionHandler(InValidToken.class)
    public ResponseEntity<?> duplicate(InValidToken exception){
        return  new ResponseEntity<String>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> serverError(Exception exception){
        return  new ResponseEntity<String>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<?> accountNotFound(AccountNotFound exception){
        return  new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
