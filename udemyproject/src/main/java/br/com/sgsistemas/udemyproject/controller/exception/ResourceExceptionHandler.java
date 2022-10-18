package br.com.sgsistemas.udemyproject.controller.exception;

import br.com.sgsistemas.udemyproject.service.exceptions.DataBaseException;
import br.com.sgsistemas.udemyproject.service.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;


@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not Found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandartError standartError = new StandartError(Instant.now(), httpStatus.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standartError);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> dataBaseError(DataBaseException e, HttpServletRequest request){
        String error = "DataBase error";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandartError standartError = new StandartError(Instant.now(), httpStatus.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standartError);
    }
}
