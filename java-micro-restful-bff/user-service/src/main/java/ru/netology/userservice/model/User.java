package ru.netology.userservice.model;

/**
 * Модель пользователя.
 * Содержит идентификатор, контактные данные и адрес доставки.
 */
public record User(
        Long id,
        String fullName,
        String deliveryAddress,
        String phone,
        String email
) {
}
