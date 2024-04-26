package uz.pdp.online.jayxun.todaytest22s.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailOrUserNameAlreadyExistsExceptions.class)
    public ResponseEntity<?> emailOrUserNameAlreadyExistsExceptions(EmailOrUserNameAlreadyExistsExceptions exceptions) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exceptions.getMessage());
    }
}
