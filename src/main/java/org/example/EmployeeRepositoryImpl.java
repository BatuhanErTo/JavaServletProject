package org.example;

import java.util.ArrayList;
import java.util.List;


public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static EmployeeRepositoryImpl INSTANCE;
    private final List<Employee> employeesDB;

    private EmployeeRepositoryImpl() {
        employeesDB = new ArrayList<>();
        Employee employee1 = new Employee(1L, "Batuhan", "Erol", 2000.0);
        employeesDB.add(employee1);
        Employee employee2 = new Employee(2L, "Bahn", "Erol", 3000.0);
        employeesDB.add(employee2);
        Employee employee3 = new Employee(3L, "Sadik", "Pacaci", 4000.0);
        employeesDB.add(employee3);
        Employee employee4 = new Employee(4L, "Jack", "Felix", 5000.0);
        employeesDB.add(employee4);
    }

    public static synchronized EmployeeRepositoryImpl createInstance() {
        if (INSTANCE == null) INSTANCE = new EmployeeRepositoryImpl();
        return INSTANCE;
    }

    @Override
    public Employee getEmployee(Long id) {
       return employeesDB.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeesDB;
    }
}
