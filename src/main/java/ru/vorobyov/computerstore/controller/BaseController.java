package ru.vorobyov.computerstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Controller with basic methods
 */
public abstract class BaseController {
    /**
     * Get not found response response entity.
     *
     * @param message response message
     * @return the response entity
     */
    ResponseEntity<String> getNotFoundResponse(String message){
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    /**
     * Get bad request response response entity.
     *
     * @param message response message
     * @return the response entity
     */
    ResponseEntity<String> getBadRequestResponse(String message){
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    /**
     * Get created response response entity.
     *
     * @return the response entity
     */
    ResponseEntity<String> getCreatedResponse(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Get service unavailable response response entity.
     *
     * @param message response message
     * @return the response entity
     */
    ResponseEntity<String> getServiceUnavailableResponse(String message){
        return new ResponseEntity<>(message, HttpStatus.SERVICE_UNAVAILABLE);
    }

}
