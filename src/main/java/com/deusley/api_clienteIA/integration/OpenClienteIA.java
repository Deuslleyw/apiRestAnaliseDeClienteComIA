package com.deusley.api_clienteIA.integration;

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

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer" + apiKey)
            .build();
    public String classificarCliente(String prompt){
        String requestBody = "{" + "\"model\": \"gpt-3.5-turbo\","
                                 + "\"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]"
                                 + "}";
        String responseIA = webClient.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return responseIA;
    }
}
