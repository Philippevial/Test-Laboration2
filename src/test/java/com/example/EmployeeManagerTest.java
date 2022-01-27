package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    EmployeeRepository employeeRepository = new EmployeeRepositoryStub(List.of(
            new Employee("123", 100.0),
            new Employee("456", 99.0),
            new Employee("789", 101.0)));
    BankService bankService = mock(BankService.class);
    EmployeeManager employeeManager = new EmployeeManager(employeeRepository,bankService);




    @Test
    void payEmployeesShouldReturnThree() {
        var result = employeeManager.payEmployees();

        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenIsPaidIsFalse() {
        doThrow(new RuntimeException())
                .when(bankService)
                        .pay(anyString(),anyDouble());

        employeeManager.payEmployees();

        assertThat(employeeRepository.findAll().get(0).isPaid()).isFalse();
    }
}