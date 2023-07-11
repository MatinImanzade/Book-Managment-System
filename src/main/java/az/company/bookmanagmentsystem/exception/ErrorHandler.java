package az.company.bookmanagmentsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleBookNotFoundException(BookNotFoundException bookNotFoundException){
        return new ExceptionResponse(400,bookNotFoundException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMethodArgumentNotValidExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ExceptionResponse(400,methodArgumentNotValidException.getMessage());
    }
}
