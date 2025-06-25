package com.archives.workflow.constants;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.archives.workflow.models.Projects;

public class ProjectResponseEntity {

    /**
     * 
     * @param <T>        generico que nos permira saber que tipo de dato sera
     *                   retornado en el cuerpo de la peticion
     * @param client_id  id del cliente en la base de datos
     * @param id         id del proyecto en la base de datos
     * @param httpStatus status code que sera retornado al cliente ej: 200, 203, 404
     *                   , 500 etc.
     * @param returnType mensaje de retorno si las validaciones salieron correcto
     * @param error      mensaje de error si las validaciones retornaron bad request
     * @return retorna error / cuerpo - returntype / cuerpo
     */
    public static <T> ResponseEntity<T> Validate(UUID client_id, Integer id, HttpStatus httpStatus, T returnType,
            T error) {
        if (client_id == null)
            return ResponseEntity.badRequest().body(error);
        if (id instanceof Integer)
            return ResponseEntity.ok().body(error);

        return switch (httpStatus) {
            case CREATED -> ResponseEntity.status(HttpStatus.CREATED).body(returnType);
            case OK -> ResponseEntity.ok(returnType);
            default -> throw new IllegalArgumentException("Unsupported HTTP status");
        };
    }

    /**
     * 
     * @param <T>        generico que nos permira saber que tipo de dato sera
     *                   retornado en el cuerpo de la peticion
     * @param client_id  id del cliente en la base de datos
     * @param httpStatus status code que sera retornado al cliente ej: 200, 203, 404
     *                   , 500 etc.
     * @param returnType mensaje de retorno si las validaciones salieron correcto
     * @param error      mensaje de error si las validaciones retornaron bad request
     * @return retorna error / cuerpo - returntype / cuerpo
     */
    public static <T> ResponseEntity<T> Validate(UUID client_id, HttpStatus httpStatus, T returnType,
            T error) {
        if (client_id == null)
            return ResponseEntity.badRequest().body(error);

        return switch (httpStatus) {
            case CREATED -> ResponseEntity.status(HttpStatus.CREATED).body(returnType);
            case OK -> ResponseEntity.ok(returnType);
            default -> throw new IllegalArgumentException("Unsupported HTTP status");
        };
    }

    /**
     * 
     * @param <T>        generico que nos permira saber que tipo de dato sera
     *                   retornado en el cuerpo de la peticion
     * @param client_id  id del cliente en la base de datos
     * @param projects   proyecto el cual se le asignara a un cliente ya sea agregar
     *                   modificar eliminar etc
     * @param httpStatus status code que sera retornado al cliente ej: 200, 203, 404
     *                   , 500 etc.
     * @param returnType mensaje de retorno si las validaciones salieron correcto
     * @param error      mensaje de error si las validaciones retornaron bad request
     * @return retorna error / cuerpo - returntype / cuerpo
     */
    public static <T> ResponseEntity<T> Validate(UUID client_id, Projects projects, HttpStatus httpStatus,
            T returnType,
            T error) {
        if (client_id == null)
            return ResponseEntity.badRequest().body(error);

        if (projects == null)
            return ResponseEntity.badRequest().body(error);

        return switch (httpStatus) {
            case CREATED -> ResponseEntity.status(HttpStatus.CREATED).body(returnType);
            case OK -> ResponseEntity.ok(returnType);
            default -> throw new IllegalArgumentException("Unsupported HTTP status");
        };
    }

    /**
     * 
     * @param <T>        generico que nos permira saber que tipo de dato sera
     *                   retornado en el cuerpo de la peticion
     * @param client_id  id del cliente en la base de datos
     * @param id         id del proyecto en la base de datos
     * @param projects   proyecto el cual se le asignara a un cliente ya sea agregar
     *                   modificar eliminar etc
     * @param httpStatus status code que sera retornado al cliente ej: 200, 203, 404
     *                   , 500 etc.
     * @param returnType mensaje de retorno si las validaciones salieron correcto
     * @param error      mensaje de error si las validaciones retornaron bad request
     * @return retorna error / cuerpo - returntype / cuerpo
     */
    public static <T> ResponseEntity<T> Validate(UUID client_id, Integer id, Projects projects, HttpStatus httpStatus,
            T returnType,
            T error) {
        if (client_id == null)
            return ResponseEntity.badRequest().body(error);

        if (projects == null)
            return ResponseEntity.badRequest().body(error);

        if (!(id instanceof Integer))
            return ResponseEntity.badRequest().body(error);

        return switch (httpStatus) {
            case CREATED -> ResponseEntity.status(HttpStatus.CREATED).body(returnType);
            case OK -> ResponseEntity.ok(returnType);
            default -> throw new IllegalArgumentException("Unsupported HTTP status");
        };
    }
}
