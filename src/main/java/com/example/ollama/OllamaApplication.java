package com.example.ollama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OllamaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OllamaApplication.class, args);
    }

}
