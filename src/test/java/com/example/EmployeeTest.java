package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class EmployeeTest {

    @Test
    void getIDShouldReturnOneTwoThree() {
        Employee employee = new Employee("123", 0.0);

        var result = employee.getId();

        assertThat(result).isEqualTo("123");
    }

}