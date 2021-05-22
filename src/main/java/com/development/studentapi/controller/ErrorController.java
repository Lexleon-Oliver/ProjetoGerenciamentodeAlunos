package com.development.studentapi.controller;

import com.development.studentapi.dto.response.ErrorMessageResponse;
import com.development.studentapi.exception.StudentNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageResponse studentNotFoundExample(Exception ex, WebRequest req){
        return new ErrorMessageResponse(404, "ERRO-4732", ex.getMessage(), "Student not found", "Invalid Request Exception");
    }
}
