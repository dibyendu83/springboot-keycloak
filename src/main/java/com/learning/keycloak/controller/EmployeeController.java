package com.learning.keycloak.controller;

import com.learning.keycloak.dto.Employee;
import com.learning.keycloak.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    @Operation(description = "Get all the employee details", summary = "Return all the employees", tags = {"employees"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Employee.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Do not have permission to access resource", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "401", description = "unauthorized/Invalid token", content = {@Content(schema = @Schema())})
    })
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('client_user')")
    @Parameter(name = "id", description = "Search employee by Id", example = "1")
    @Operation(description = "Get a Employee object by specifying its id.", summary = "Retrieve a employee by Id", tags = {"employees"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Employee.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Do not have permission to access resource", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "401", description = "unauthorized/Invalid token", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", description = "The Employee with given Id was not found.", content = { @Content(schema = @Schema()) })
    })
    public Employee getEmployee(@PathVariable String id){
        return employeeService.getEmployeeById(Long.parseLong(id));
    }
}
