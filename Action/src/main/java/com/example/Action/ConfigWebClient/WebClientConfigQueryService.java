package com.example.Action.ConfigWebClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigQueryService {

    @Bean(name = "queryServiceWebClient")
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:1001") // Base URL for Query Service
                .build();
    }
}

