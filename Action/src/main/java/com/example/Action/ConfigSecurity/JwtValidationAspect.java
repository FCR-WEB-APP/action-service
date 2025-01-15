package com.example.Action.ConfigSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class JwtValidationAspect {

    private final JwtValidatorService jwtValidatorService;

    public JwtValidationAspect(JwtValidatorService jwtValidatorService) {
        this.jwtValidatorService = jwtValidatorService;
    }

    @Before("execution(* com.example.Action.Controller..*(..))")
    public void validateTokenBeforeApiCall() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        String username = request.getHeader("username");
        if (token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException("Missing or invalid token");
        }
        jwtValidatorService.validateToken(token,username);
    }
}
