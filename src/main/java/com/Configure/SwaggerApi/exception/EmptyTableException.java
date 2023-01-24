package com.Configure.SwaggerApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Table might be empty")
public class EmptyTableException extends Exception {
    public EmptyTableException(String message)
    {
        super(message);
    }
}

