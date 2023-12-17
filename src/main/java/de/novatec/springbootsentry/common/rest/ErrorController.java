package de.novatec.springbootsentry.common.rest;

import de.novatec.springbootsentry.common.exceptions.CustomException;
import io.sentry.Sentry;
import io.sentry.protocol.SentryId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ErrorController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        SentryId sentryId = Sentry.captureException(ex);
        return new ResponseEntity<>(sentryId.toString(), HttpStatus.valueOf(ex.getErrorCode()));

        // Sentry.captureException(ex);
        // return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(ex.getErrorCode()));
    }
}
