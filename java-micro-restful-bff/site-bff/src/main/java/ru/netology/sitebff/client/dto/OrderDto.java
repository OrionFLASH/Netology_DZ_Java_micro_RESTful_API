package ru.netology.sitebff.client.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO заказа, получаемый от order-service.
 */
public record OrderDto(
        Long id,
        Long userId,
        BigDecimal amount,
        String currency,
        List<String> items
) {
}
