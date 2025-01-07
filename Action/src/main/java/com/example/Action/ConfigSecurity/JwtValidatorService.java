package com.example.Action.ConfigSecurity;
import com.example.Action.Exception.ForbiddenException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class JwtValidatorService {

    private final WebClient webClient;

    public JwtValidatorService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void validateToken(String token,String username) {
        try {
            webClient.get()
                    .uri("/validToken")
                    .header("Authorization", token)
                    .header("username",username)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // Synchronously waits for response
        } catch (WebClientResponseException e) {
            throw new ForbiddenException("Invalid token: 403 Forbidden");
        }
    }
}

