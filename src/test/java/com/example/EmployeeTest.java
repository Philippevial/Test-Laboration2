package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class EmployeeTest {
    Employee employee = new Employee("123", 100.0);

    @Test
    void getIDShouldReturnOneTwoThree() {
        var result = employee.getId();

        assertThat(result).isEqualTo("123");
    }

    @Test
    void setIDShouldGiveEmployeeEnteredID() {
        employee.setId("456");

        assertThat(employee.getId()).isEqualTo("456");
    }

    @Test
    void getSalaryShouldReturn100() {
        var result = employee.getSalary();

        assertThat(result).isEqualTo(100.0);
    }

    @Test
    void setSalaryShouldReplaceSalaryWith1000() {
        employee.setSalary(1000.0);

        assertThat(employee.getSalary()).isEqualTo(1000.0);
    }

    @Test
    void isPaidShouldReturnFalse() {
        var result = employee.isPaid();

        assertThat(result).isFalse();
    }

    @Test
    void setPaidShouldReturnTrue() {
        employee.setPaid(true);

        assertThat(employee.isPaid()).isTrue();
    }
}