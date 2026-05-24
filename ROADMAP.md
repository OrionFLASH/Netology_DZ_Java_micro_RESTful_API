# Roadmap: RESTful API и паттерн BFF

## Задача
Реализовать три микросервиса на Spring Boot: пользователи, заказы и BFF-агрегатор.

## Этапы

- [v] Инициализация репозитория: структура, Docs, README, parent POM
- [v] Микросервис пользователей (`GET /api/users/{userId}`)
- [v] Микросервис заказов (`GET /api/orders/by-user/{user}`)
- [v] BFF-микросервис (`GET /api/site-bff/user/{userId}`)
- [v] Интеграционное тестирование и финальная документация
- [w] Push в удалённый репозиторий
