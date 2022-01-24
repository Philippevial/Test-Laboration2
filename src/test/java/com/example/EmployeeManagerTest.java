package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EmployeeManagerTest {


    EmployeeRepository employeeRepository = new EmployeeRepositoryStub(List.of(
            new Employee("123", 100.0),
            new Employee("456", 99.0),
            new Employee("789", 101.0)));
    BankService bankService = mock(BankService.class);
    EmployeeManager employeeManager = new EmployeeManager(employeeRepository,bankService);




    @Test
    void payEmployeesShouldReturnTwo() {
        var result = employeeManager.payEmployees();

        assertThat(result).isEqualTo(3);
    }
}