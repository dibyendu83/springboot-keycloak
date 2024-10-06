package com.learning.keycloak.service;

import com.learning.keycloak.dto.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;

    @PostConstruct
    public void populateEmployees(){
        employees = Arrays.asList(
                new Employee(1, "Aditya", "Sinha", "aditya.sinha@gmail.com", true),
                new Employee(2, "Faisal", "moideen", "faisalmoideen@gmail.com", true),
                new Employee(3, "Manika", "Sharma", "sharma.Manika@gmail.com", true),
                new Employee(4, "Joe", "Bren", "joe.bren@gmail.com", true),
                new Employee(5, "Vikram", "Mathur", "vikram.mathur@gmail.com", true)
                );
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeById(long id){
       return employees.stream().filter(e -> e.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("No Employee Found with {}", id)));
    }
}
