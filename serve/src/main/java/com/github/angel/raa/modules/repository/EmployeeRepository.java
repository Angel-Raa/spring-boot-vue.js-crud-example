package com.github.angel.raa.modules.repository;

import com.github.angel.raa.modules.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
