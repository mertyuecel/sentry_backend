package de.novatec.springbootsentry.common.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends Exception {
    private int errorCode;

    public CustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
