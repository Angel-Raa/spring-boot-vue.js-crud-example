package com.github.angel.raa.modules.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class EmployeeNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    private boolean error;
    public EmployeeNotFoundException(String message, boolean error) {
        this.message = message;
        this.error = error;
    }
}
