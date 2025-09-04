package com.deusley.api_clienteIA.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenAiKeyChecker {

        @Value("${spring.ai.openai.api-key}")
        private String apiKey;

        @PostConstruct
        public void checkKey() {
            if (apiKey == null || apiKey.isBlank()) {
                System.out.println("❌ API Key NÃO foi carregada!");
            } else {
                System.out.println("✅ API Key carregada com sucesso: " + apiKey.substring(0, 7) + "...");
            }
        }
    }
