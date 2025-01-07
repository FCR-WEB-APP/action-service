//package com.example.Action.ExternalService;
//
//import com.example.Action.Configuration.WebClientConfig;
//import org.springframework.stereotype.Service;
//
//import java.net.http.HttpHeaders;
//import java.util.Map;
//
//@Service
//public class ValidTokenWebClient {
//
//    private final WebClientConfig webClientConfig;
//
//    public ValidTokenWebClient(WebClientConfig webClientConfig) {
//        this.webClientConfig = webClientConfig;
//    }
//
//    public Mono<String> validToken(String token) {
//        return webClientBuilder.build()
//                .get()
//                .uri("/validToken")
//                .header(HttpHeaders.AUTHORIZATION,token)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
//
//}
