package de.novatec.springbootsentry.common.rest;

import de.novatec.springbootsentry.common.exceptions.CustomException;
import io.sentry.Sentry;
import io.sentry.protocol.SentryId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
class ErrorController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
         Sentry.captureException(ex);
         return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(ex.getErrorCode()));
    }
}
