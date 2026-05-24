# Чеклист соответствия заданию: RESTful API и BFF

**Дата проверки:** 2026-05-24  
**Задание:** [`assignment-micro-restful-bff.md`](assignment-micro-restful-bff.md)

## Требования к микросервисам

| № | Требование | Статус | Реализация |
|---|------------|--------|------------|
| 1 | Микросервис пользователей с HTTP API | ✅ | `user-service`, порт 8081 |
| 2 | `RestController` + `spring-boot-starter-web` (users) | ✅ | `UserController`, `user-service/pom.xml` |
| 3 | `GET /api/users/{userId}` | ✅ | `UserController.getUser()` |
| 4 | Модель User: Id, ФИО, адрес, телефон, email | ✅ | `User` record: `id`, `fullName`, `deliveryAddress`, `phone`, `email` |
| 5 | Микросервис заказов с HTTP API | ✅ | `order-service`, порт 8082 |
| 6 | `RestController` + `spring-boot-starter-web` (orders) | ✅ | `OrderController`, `order-service/pom.xml` |
| 7 | `GET /api/orders/by-user/{user}` | ✅ | `OrderController.getOrdersByUser()` |
| 8 | Модель Order: Id, UserId, сумма, валюта, позиции | ✅ | `Order` record: `id`, `userId`, `amount`, `currency`, `items` |
| 9 | BFF с HTTP API | ✅ | `site-bff`, порт 8080 |
| 10 | `RestController` + `spring-boot-starter-web` (BFF) | ✅ | `SiteBffController`, `site-bff/pom.xml` |
| 11 | `GET /api/site-bff/user/{userId}` | ✅ | `SiteBffController.getUserProfile()` |
| 12 | BFF вызывает оба микросервиса | ✅ | `UserServiceClient`, `OrderServiceClient` |
| 13 | BFF агрегирует данные в одну модель | ✅ | `UserSiteProfile` + `OrderSummary` |
| 14 | BFF не хранит данные | ✅ | Нет `@Repository` и in-memory хранилищ в `site-bff` |

## Результаты интеграционного тестирования

Сборка:

```bash
cd java-micro-restful-bff && mvn clean package -DskipTests
# BUILD SUCCESS — все 3 модуля
```

Запросы (все три сервиса должны быть запущены):

| Проверка | Команда | Ожидание | Результат |
|----------|---------|----------|-----------|
| Профиль пользователя | `GET /api/users/1` | 200, 5 полей User | ✅ |
| Заказы пользователя | `GET /api/orders/by-user/1` | 200, 2 заказа | ✅ |
| Агрегация BFF | `GET /api/site-bff/user/1` | 200, user + 2 orders | ✅ |
| Другой пользователь | `GET /api/site-bff/user/2` | 200, 1 заказ | ✅ |
| Заказ в USD | `GET /api/site-bff/user/3` | 200, currency=USD | ✅ |
| Несуществующий user | `GET /api/users/999` | 404 | ✅ |
| BFF пробрасывает 404 | `GET /api/site-bff/user/999` | 404 | ✅ |
| Пустой список заказов | `GET /api/orders/by-user/999` | 200, `[]` | ✅ |

## Пример агрегированного ответа BFF

```json
{
  "userId": 1,
  "fullName": "Иванов Иван Иванович",
  "deliveryAddress": "г. Москва, ул. Ленина, д. 10",
  "phone": "+7-900-111-22-33",
  "email": "ivanov@example.com",
  "orders": [
    {
      "orderId": 101,
      "amount": 4599.0,
      "currency": "RUB",
      "items": ["Наушники", "Чехол для телефона"]
    },
    {
      "orderId": 102,
      "amount": 1290.5,
      "currency": "RUB",
      "items": ["Кабель USB-C"]
    }
  ]
}
```

## Вывод

Реализация **полностью соответствует** условиям задания Netology по RESTful API и паттерну BFF.
