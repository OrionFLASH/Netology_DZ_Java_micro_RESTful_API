package ru.netology.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входа микросервиса заказов.
 * Предоставляет REST API для получения заказов пользователя.
 */
@SpringBootApplication
public class OrderServiceApplication {

    /**
     * Запуск Spring Boot приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
