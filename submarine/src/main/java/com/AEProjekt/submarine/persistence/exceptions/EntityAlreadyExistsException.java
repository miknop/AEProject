package com.AEProjekt.submarine.persistence.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to check if Database Entites are already existant to prevent double creation.
 */
@ResponseStatus(value = HttpStatus.IM_USED, reason = "An entity with this name already exists in your Database. Names need to be unique.")
public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException() {

    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    public EntityAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected EntityAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

