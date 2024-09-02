package org.example;

import java.util.List;

public interface EmployeeRepository {
    Employee getEmployee(Long id);
    List<Employee> getAllEmployees();
}
