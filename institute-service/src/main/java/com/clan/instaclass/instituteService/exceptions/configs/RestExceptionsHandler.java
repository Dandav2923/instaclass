package com.clan.instaclass.instituteService.exceptions.configs;

import com.clan.instaclass.instituteService.exceptions.InstituteNotFoundException;
import com.clan.instaclass.instituteService.exceptions.SubjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InstituteNotFoundException.class)
    public final ResponseEntity<ErrorResponse> instituteNotFound(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMsg(e.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public final ResponseEntity<ErrorResponse> subjectNotFound(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMsg(e.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
