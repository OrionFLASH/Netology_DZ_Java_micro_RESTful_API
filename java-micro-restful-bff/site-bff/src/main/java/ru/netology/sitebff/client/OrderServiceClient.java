package ru.netology.sitebff.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.netology.sitebff.client.dto.OrderDto;

import java.util.List;

/**
 * HTTP-клиент для получения заказов из order-service.
 */
@Component
public class OrderServiceClient {

    private final RestClient restClient;

    public OrderServiceClient(@Qualifier("orderServiceRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * Запрашивает список заказов пользователя.
     *
     * @param userId идентификатор пользователя
     * @return список заказов (может быть пустым)
     */
    public List<OrderDto> getOrdersByUserId(Long userId) {
        return restClient.get()
                .uri("/api/orders/by-user/{user}", userId)
                .retrieve()
                .body(new ParameterizedTypeReference<List<OrderDto>>() {
                });
    }
}
