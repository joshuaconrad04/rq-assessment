package com.challenge.api.service;

import com.challenge.api.repository.EmployeeRepository;
import com.challenge.api.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    // Inject the EmployeeRepository
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Implement the Get all Employees Endpoint
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    // Implement the Get Employee by UUID Endpoint
    public Employee getEmployeeByUuid(UUID uuid) {
        return employeeRepository.findEmployeeById(uuid);
    }

    // Implement the Create Employee Endpoint
    public Employee createEmployee(Employee employee) {
        if (employee == null)
            return null;
        // Before Creating may want to check Database for existing Employee or Ensure
        // that the the employee object has data that even makes sense
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }
        return employeeRepository.saveEmployee(employee);
    }
}
