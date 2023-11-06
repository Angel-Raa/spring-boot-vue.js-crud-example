package com.github.angel.raa.modules.service.impl;

import com.github.angel.raa.modules.dto.EmployeeDTO;
import com.github.angel.raa.modules.exception.EmployeeNotFoundException;
import com.github.angel.raa.modules.models.Employee;
import com.github.angel.raa.modules.repository.EmployeeRepository;
import com.github.angel.raa.modules.service.interfaces.EmployeeService;
import com.github.angel.raa.modules.utils.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map((dto) -> new EmployeeDTO(dto.getId(), dto.getFistName(), dto.getLastName(), dto.getEmail(), dto.getDepartment()))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeById(@NonNull Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found "));
        return convertToDto(employee);
    }

    @Override
    @Transactional
    public Response saveEmployee(@NonNull EmployeeDTO body) {
        Employee employee = convertToEntity(body);
        employeeRepository.save(employee);
        return Response.builder().message("Employee saved successfully").code(201).error(false).build();
    }

    @Override
    @Transactional
    public Response updateEmployee(@NonNull Long id, EmployeeDTO body) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found "));
        employee.setFistName(body.getFistName());
        employee.setLastName(body.getLastName());
        employee.setEmail(body.getEmail());
        employee.setDepartment(body.getDepartment());
        employeeRepository.save(employee);
        return Response.builder().message("employee successfully updated").code(200).error(false).build();
    }

    @Override
    @Transactional
    public Response deleteEmployee(@NonNull Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found "));
        employeeRepository.delete(employee);
        return Response.builder().message("Employee successfully deleted").code(200).error(false).build();
    }

    private EmployeeDTO convertToDto(@NonNull Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(employee.getId());
        dto.setFistName(employee.getFistName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        return dto;
    }

    private Employee convertToEntity(@NonNull EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getEmployeeId());
        employee.setFistName(dto.getFistName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        return employee;
    }
}
