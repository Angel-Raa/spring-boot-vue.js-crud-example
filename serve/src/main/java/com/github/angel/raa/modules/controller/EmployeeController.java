package com.github.angel.raa.modules.controller;

import com.github.angel.raa.modules.dto.EmployeeDTO;
import com.github.angel.raa.modules.service.interfaces.EmployeeService;
import com.github.angel.raa.modules.utils.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/all-employee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("/employee-by/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@Valid @PathVariable(value = "employeeId") @Min(1) Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/create-employee")
    public ResponseEntity<Response> createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }

    @PutMapping("/update-employee/{id}")
    public ResponseEntity<Response> updateEmployee(@Valid @RequestBody EmployeeDTO employee, @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }


    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
