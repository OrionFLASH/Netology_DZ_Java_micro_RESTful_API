package ru.netology.orderservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.orderservice.model.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In-memory хранилище заказов для учебного задания.
 */
@Repository
public class OrderRepository {

    /** Тестовые заказы нескольких пользователей */
    private final List<Order> orders = List.of(
            new Order(101L, 1L, new BigDecimal("4599.00"), "RUB", List.of("Наушники", "Чехол для телефона")),
            new Order(102L, 1L, new BigDecimal("1290.50"), "RUB", List.of("Кабель USB-C")),
            new Order(201L, 2L, new BigDecimal("8990.00"), "RUB", List.of("Клавиатура механическая", "Коврик для мыши")),
            new Order(301L, 3L, new BigDecimal("150.00"), "USD", List.of("Книга по Java", "Книга по Spring"))
    );

    /**
     * Возвращает все заказы указанного пользователя.
     *
     * @param userId идентификатор пользователя
     * @return список заказов (может быть пустым)
     */
    public List<Order> findByUserId(Long userId) {
        return orders.stream()
                .filter(order -> order.userId().equals(userId))
                .collect(Collectors.toList());
    }
}
