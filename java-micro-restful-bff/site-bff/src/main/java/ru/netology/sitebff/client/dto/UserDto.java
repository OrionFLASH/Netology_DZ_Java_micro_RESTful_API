package ru.netology.sitebff.client.dto;

/**
 * DTO пользователя, получаемый от user-service.
 * Структура совпадает с моделью downstream-сервиса для десериализации JSON.
 */
public record UserDto(
        Long id,
        String fullName,
        String deliveryAddress,
        String phone,
        String email
) {
}
