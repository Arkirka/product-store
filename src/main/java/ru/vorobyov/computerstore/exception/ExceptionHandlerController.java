package ru.vorobyov.computerstore.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vorobyov.computerstore.dto.ApiErrorResponse;

import java.util.Date;

/**
 * A controller that intercepts thrown errors during the execution of controller methods
 */
@RestControllerAdvice
public class ExceptionHandlerController {
    /**
     * Handle method argument not valid api error response.
     *
     * @return the api error response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrorResponse handleMethodArgumentNotValid() {
        return new ApiErrorResponse(
                "Invalid request parameters",
                HttpStatus.BAD_REQUEST.value(),
                new Date()
        );
    }

    /**
     * Handle method argument not valid api error response.
     *
     * @return the api error response
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrorResponse handleConstraintViolationException() {
        return new ApiErrorResponse(
                "Invalid request parameters",
                HttpStatus.BAD_REQUEST.value(),
                new Date()
        );
    }
}
