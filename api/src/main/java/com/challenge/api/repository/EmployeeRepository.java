package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final Map<UUID, Employee> employeesDatabase = new ConcurrentHashMap<>();

    public List<Employee> findAllEmployees() {
        return new ArrayList<>(employeesDatabase.values());
    }

    public Employee findEmployeeById(UUID uuid) {
        if (employeesDatabase.get(uuid) == null) {
            return null;
        }
        return employeesDatabase.get(uuid);
    }

    public Employee saveEmployee(Employee employee) {
        employeesDatabase.put(employee.getUuid(), employee);
        return employee;
    }
}
