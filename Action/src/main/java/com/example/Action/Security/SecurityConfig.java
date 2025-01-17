package com.example.Action.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomRoleAuthorizationManager customRoleAuthorizationManager;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          CustomRoleAuthorizationManager customRoleAuthorizationManager) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customRoleAuthorizationManager = customRoleAuthorizationManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/obligour/add","/api/query/add","/api/query/delete","/api/childReview/add","api/addcasedetails","api/comments/add","api/comments/delete","api/GroupAndDivison/add","api/GroupAndDivison/delete","/api/issue-details/add","/api/issue-track/create","api/upload/add","api/upload/addFile","api/upload/delete").access(customRoleAuthorizationManager.forRole(Arrays.asList("Sr.CreditReviewer","CreditReviewer")))
                        .requestMatchers("api/update","api/comments/update","api/GroupAndDivison/update","/api/ScrToCR","/api/SpocSubmitCRTask").access(customRoleAuthorizationManager.forRole(Arrays.asList("Sr.CreditReviewer","CreditReviewer","Spoc","HeadOfFcr")))
                        .requestMatchers("/api/SubmitTaskLeader").access(customRoleAuthorizationManager.forRole(Arrays.asList("Sr.CreditReviewer","CreditReviewer","HeadOfFcr")))
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
