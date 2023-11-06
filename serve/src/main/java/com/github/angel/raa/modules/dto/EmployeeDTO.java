package com.github.angel.raa.modules.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long employeeId;
    @NotBlank(message = "campo requerido")
    private String fistName;
    @NotBlank(message = "campo requerido")
    private String lastName;
    @Email( message = "correo no valido ")
    private String email;
    @NotBlank(message = "campo requerido")
    private String department;
}
