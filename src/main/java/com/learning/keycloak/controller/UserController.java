package com.learning.keycloak.controller;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@Hidden
public class UserController {

    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public Map<String, Object> getUserRoleDetails() {
        Map<String, Object> userMap =  getLoggedInUserDetails();
        userMap.put("description", "user has user role access");
        return userMap;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('client_admin')")
    public Map<String, Object> adminUserDetails() {
        Map<String, Object> userMap =  getLoggedInUserDetails();
        userMap.put("description", "user has admin role access");
        return userMap;
    }

    private static Map getLoggedInUserDetails() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> map = new HashMap<>();
        map.put("name", jwt.getClaim("name"));
        map.put("email", jwt.getClaim("email"));
        map.put("email_verified", jwt.getClaim("email_verified"));
        List<Object> roles = (List<Object>) ((Map) jwt.getClaim("realm_access")).get("roles");
        map.put("roles", roles);
        return map;
    }
}