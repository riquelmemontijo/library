package com.biblioteca.infrastructure.exception;

import java.util.UUID;

public class RecordNotFound extends RuntimeException{

    public static final long serialVersionUID = 1l;

    public RecordNotFound(UUID id) {
        super("Record not found with id: " + id);
    }

}
