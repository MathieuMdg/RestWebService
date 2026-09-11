package com.MdgCorp.RestWebService.exception;

public class NotSavedInDatabase extends RuntimeException {
    public NotSavedInDatabase(String message) {
        super(message);
    }
}
