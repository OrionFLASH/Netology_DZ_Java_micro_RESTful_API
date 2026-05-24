package ru.netology.orderservice.service;

import org.springframework.stereotype.Service;
import ru.netology.orderservice.model.Order;
import ru.netology.orderservice.repository.OrderRepository;

import java.util.List;

/**
 * Сервисный слой для работы с заказами.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Возвращает заказы пользователя по его идентификатору.
     *
     * @param userId идентификатор пользователя
     * @return список заказов
     */
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
