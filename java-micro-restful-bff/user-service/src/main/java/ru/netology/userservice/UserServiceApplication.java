package ru.netology.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входа микросервиса пользователей.
 * Предоставляет REST API для получения профиля пользователя по идентификатору.
 */
@SpringBootApplication
public class UserServiceApplication {

    /**
     * Запуск Spring Boot приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
