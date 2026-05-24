package ru.netology.sitebff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входа BFF-микросервиса.
 * Агрегирует данные из сервисов пользователей и заказов для клиентского приложения.
 */
@SpringBootApplication
public class SiteBffApplication {

    /**
     * Запуск Spring Boot приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(SiteBffApplication.class, args);
    }
}
