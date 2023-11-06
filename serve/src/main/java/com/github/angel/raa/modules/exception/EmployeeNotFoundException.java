package com.github.angel.raa.modules.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class EmployeeNotFoundException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    public EmployeeNotFoundException(String message) {
        this.message = message;
    }
}
