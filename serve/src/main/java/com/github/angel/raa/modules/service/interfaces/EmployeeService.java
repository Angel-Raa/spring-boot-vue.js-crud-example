package com.github.angel.raa.modules.service.interfaces;

import com.github.angel.raa.modules.dto.EmployeeDTO;
import com.github.angel.raa.modules.utils.Response;
import lombok.NonNull;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(@NonNull Long id);

    Response saveEmployee(@NonNull EmployeeDTO body);

    Response updateEmployee(@NonNull Long id, EmployeeDTO body);

    Response deleteEmployee(@NonNull Long id);

}
