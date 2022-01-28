package com.example;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class EmployeeRepositoryMemoryTest {

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("123", 100.0),
            new Employee("456", 99.0),
            new Employee("789", 101.0)));

    EmployeeRepositoryMemory employeeRepository = new EmployeeRepositoryMemory(employees);


    @Test
    void emptyRepositoryShouldReturnZero() {
        EmployeeRepositoryMemory employeeRepository = new EmployeeRepositoryMemory(List.of());

        var result = employeeRepository.findAll();

        assertThat(result).size().isEqualTo(0);
    }

    @Test
    void findAllShouldReturnThree() {
        var result = employeeRepository.findAll();

        assertThat(result).size().isEqualTo(3);
    }

    @Test
    void saveShouldReturnFourWhenNewEmployeeIsSaved() {
        employeeRepository.save(new Employee("101", 110.0));

        var result = employeeRepository.findAll();

        assertThat(result).size().isEqualTo(4);
    }

    @Test
    void saveOnEmployeeIdAlreadyInListShouldOverwriteOldOne() {
        var employee = employeeRepository.findAll().get(0);

        var employeeUpgrade = employeeRepository.save(new Employee("123", 200.0));

        assertThat(employees).doesNotContain(employee).contains(employeeUpgrade);
    }
}