package com.archives.workflow.constants;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.archives.workflow.models.Projects;

public class ProjectResponseEntity {

    public static <T> ResponseEntity<?> uuidValidate(UUID client_id, HttpStatus httpStatus,
            T returnType) {
        if (!(client_id instanceof UUID))
            return ResponseEntity.badRequest().body("Expected UUID for client_id");
        switch (httpStatus) {
            case CREATED -> {
                return ResponseEntity.status(HttpStatus.CREATED).body(returnType);
            }
            case OK -> {
                return (ResponseEntity<?>) ResponseEntity.ok();
            }
            default -> throw new AssertionError();
        }
    }

    public static <T> ResponseEntity<?> uuidValidate(UUID client_id, Projects projects, HttpStatus httpStatus,
            T returnType) {
        if (!(client_id instanceof UUID))
            return ResponseEntity.badRequest().body("Expected UUID for client_id");
        if (projects == null)
            return ResponseEntity.badRequest().body("The project is null expected object full!");

        switch (httpStatus) {
            case CREATED -> {
                return ResponseEntity.status(HttpStatus.CREATED).body(returnType);
            }
            case OK -> {
                return (ResponseEntity<?>) ResponseEntity.ok();
            }
            default -> throw new AssertionError();
        }
    }
}
