package lk.epic.assignmentone.advice;

import lk.epic.assignmentone.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@CrossOrigin
@Validated
public class AppWideExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseUtil> handleExceptions(Exception e) {
        System.out.println(e.getMessage());
        System.out.println(e.getLocalizedMessage());
        System.out.println(e.getClass().getName());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseUtil("06", "Bad Request", null));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseUtil> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(new ResponseUtil("06", "Validation Failed", errors));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ResponseUtil> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach((error) -> {
            String fieldName = error.getPropertyPath().toString().split("\\.")[1];
            String errorMessage = error.getMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(new ResponseUtil("06", "Validation Failed", errors));
    }
}
