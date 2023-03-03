package com.biblioteca.infrastructure.exception;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException{

    public static final long serialVersionUID = 1l;

    public RecordNotFoundException(UUID id) {
        super("Record not found with id: " + id);
    }

}
