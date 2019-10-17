package com.stackroute.muzix.exceptionHandlerTrack;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrackExceptionHandler {
    @ExceptionHandler
    public String handleException(TrackAlreadyExistsException ex){
        return ex.getMessage();
    }
    @ExceptionHandler String handelNotFoundException(TrackNotFoundException ex){
        return ex.getMessage();
    }

}
