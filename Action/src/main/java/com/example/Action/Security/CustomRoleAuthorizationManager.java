package com.example.Action.Security;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomRoleAuthorizationManager {

    public AuthorizationManager<RequestAuthorizationContext> forRole(List<String> requiredRole) {
        return (authenticationSupplier, context) -> {
            Authentication authentication = authenticationSupplier.get();
            if (authentication == null || !authentication.isAuthenticated()) {
                return new AuthorizationDecision(false);
            }
for(String role:requiredRole){

    boolean hasRole= authentication.getAuthorities().stream()
            .map(authority -> authority.getAuthority()) // Extract the role names
            .anyMatch(auth -> auth.trim().equalsIgnoreCase(role));
    if(hasRole)
        return new AuthorizationDecision(hasRole);
}
            // Iterate through all roles of the user and check if any match the required role
            // Compare the role case-insensitively

            return new AuthorizationDecision(false);
        };
    }
}
