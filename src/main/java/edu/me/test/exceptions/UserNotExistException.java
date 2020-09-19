package edu.me.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String message){
        super(message);
    }
}
