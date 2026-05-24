package ru.netology.orderservice.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Модель заказа пользователя.
 * Содержит сумму, валюту и перечень позиций.
 */
public record Order(
        Long id,
        Long userId,
        BigDecimal amount,
        String currency,
        List<String> items
) {
}
