package com.github.angel.raa.modules.exception;

import com.github.angel.raa.modules.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Response> employeeNotFoundException(EmployeeNotFoundException e){
        return ResponseEntity.status(404).body(new Response(e.getMessage(),404, e.isError()));
    
    }
    
}
