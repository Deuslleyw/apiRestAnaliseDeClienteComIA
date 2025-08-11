package com.deusley.api_clienteIA.integration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class OpenClienteIA {

    @Value("${open.api.key}")
    private String apiKey;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

    public String classificarCliente(String prompt) {
        String requestBody = """
            {
              "model": "gpt-3.5-turbo",
              "messages": [{"role": "user", "content": "%s"}]
            }
            """.formatted(prompt);

        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
