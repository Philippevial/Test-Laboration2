package com.example;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class EmployeeRepositoryMemoryTest {


    @Test
    void emptyRepositoryShouldReturnZero() {
        EmployeeRepositoryMemory employeeRepository = new EmployeeRepositoryMemory(List.of());

        var result = employeeRepository.findAll();

        assertThat(result).size().isEqualTo(0);
    }

}