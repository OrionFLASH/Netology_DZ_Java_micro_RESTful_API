package ru.netology.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.orderservice.model.Order;
import ru.netology.orderservice.service.OrderService;

import java.util.List;

/**
 * REST-контроллер микросервиса заказов.
 * Endpoint: GET /api/orders/by-user/{user}
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Возвращает список заказов пользователя.
     *
     * @param user идентификатор пользователя
     * @return список заказов
     */
    @GetMapping("/by-user/{user}")
    public List<Order> getOrdersByUser(@PathVariable("user") Long user) {
        return orderService.getOrdersByUserId(user);
    }
}
