package ru.netology.sitebff.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Агрегированная модель профиля пользователя для клиентского приложения.
 * Объединяет данные пользователя и его заказы в одном ответе BFF.
 */
public record UserSiteProfile(
        Long userId,
        String fullName,
        String deliveryAddress,
        String phone,
        String email,
        List<OrderSummary> orders
) {

    /**
     * Краткое представление заказа в составе профиля пользователя.
     */
    public record OrderSummary(
            Long orderId,
            BigDecimal amount,
            String currency,
            List<String> items
    ) {
    }
}
