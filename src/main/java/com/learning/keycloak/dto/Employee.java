package com.learning.keycloak.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Employee Model Information")
public class Employee {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Employee Id", example = "123")
    private long id;
    @Schema(description = "Employee's first name", example = "Dibyendu")
    private String firstName;
    @Schema(description = "Employee's last name", example = "Rakshit")
    private String lastName;
    @Schema(description = "Employee's email id", example = "dibyendu.rakshit@gmail.com")
    private String emailId;
    @Schema(description = "Employee is active or not", example = "true")
    private boolean isActive;
}
