package hu.flowacademy.eta.demo;

import hu.flowacademy.eta.demo.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public List<String> handleRuntimeException(RuntimeException e) {
        System.err.println("got a validation error: " + e);
        return List.of(e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<String> youShallNotPass(Throwable t) {
        System.err.println(":'( " + t.getMessage());
        return List.of("no no.... Mr. Error not here");
    }

}
