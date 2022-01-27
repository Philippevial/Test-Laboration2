package com.example;

import java.util.List;

public class EmployeeRepositoryMemory implements EmployeeRepository {

    List<Employee> employees;

    public EmployeeRepositoryMemory(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(e.getId())) {
                employees.remove(employees.get(i));
            }
        }
        employees.add(e);
        return e;
    }
}
