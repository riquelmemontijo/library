package com.library.infrastructure.exception;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(UUID id) {
        super("Record not found with id: " + id);
    }
    public RecordNotFoundException(String email) {
        super("Record not found with email: " + email);
    }

}
