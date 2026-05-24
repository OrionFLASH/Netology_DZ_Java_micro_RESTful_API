package ru.netology.sitebff.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Конфигурация HTTP-клиентов для обращения к downstream-микросервисам.
 */
@Configuration
public class RestClientConfig {

    @Value("${bff.user-service.url}")
    private String userServiceUrl;

    @Value("${bff.order-service.url}")
    private String orderServiceUrl;

    /**
     * REST-клиент для микросервиса пользователей.
     */
    @Bean
    public RestClient userServiceRestClient(RestClient.Builder builder) {
        return builder.baseUrl(userServiceUrl).build();
    }

    /**
     * REST-клиент для микросервиса заказов.
     */
    @Bean
    public RestClient orderServiceRestClient(RestClient.Builder builder) {
        return builder.baseUrl(orderServiceUrl).build();
    }
}
