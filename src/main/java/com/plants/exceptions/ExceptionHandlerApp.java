package com.plants.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerApp {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handlerResourceAlreadyExistsException(
            ResourceAlreadyExistsException ex,
            HttpServletRequest request
    ) {
        String message = String.format(
                "%s already exists with %s %s",
                ex.getName(),
                ex.getAttribute(),
                ex.getAttributeValue()
        );
        ProblemDetail problemDetail = new ProblemDetail(
                "Resource already exists exception",
                List.of(new Violation(ex.getName(), message))
        );

        return new ResponseEntity(problemDetail, HttpStatus.CONFLICT);
    }

}