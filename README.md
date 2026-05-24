# Netology — Java: микросервисы и RESTful API

Учебный репозиторий с реализациями домашних заданий курса по Java.

## Задания

| Каталог | Тема |
|---------|------|
| [`java-micro-restful-bff/`](java-micro-restful-bff/) | RESTful API и паттерн BFF (Backend-for-Frontend) |

Исходные формулировки заданий — в каталоге [`Docs/`](Docs/).  
Чеклист проверки соответствия заданию — [`Docs/verification-checklist.md`](Docs/verification-checklist.md).

## Структура проекта

```
.
├── Docs/                          # Исходные задания и материалы
├── java-micro-restful-bff/        # Реализация: 3 Spring Boot микросервиса
│   ├── user-service/              # Сервис пользователей (порт 8081)
│   ├── order-service/             # Сервис заказов (порт 8082)
│   └── site-bff/                  # BFF-агрегатор (порт 8080)
├── README.md
└── ROADMAP.md
```

## Требования

- Java 17+
- Maven 3.9+
- HTTP-клиент (curl, IntelliJ HTTP Client, Postman)

## Запуск: RESTful API и BFF

Каждый сервис запускается в отдельном терминале из корня соответствующего модуля:

```bash
# Терминал 1 — пользователи
cd java-micro-restful-bff/user-service
mvn spring-boot:run

# Терминал 2 — заказы
cd java-micro-restful-bff/order-service
mvn spring-boot:run

# Терминал 3 — BFF
cd java-micro-restful-bff/site-bff
mvn spring-boot:run
```

Либо собрать все модули одной командой из каталога `java-micro-restful-bff/`:

```bash
mvn clean package -DskipTests
```

## Проверка

### Прямые запросы к микросервисам

```bash
curl http://localhost:8081/api/users/1
curl http://localhost:8082/api/orders/by-user/1
```

### Запрос через BFF (агрегированный профиль)

```bash
curl http://localhost:8080/api/site-bff/user/1
```

Ожидаемый ответ содержит данные пользователя и список его заказов в одном JSON-объекте.

## Порты по умолчанию

| Сервис | Порт |
|--------|------|
| site-bff | 8080 |
| user-service | 8081 |
| order-service | 8082 |

URL микросервисов для BFF настраиваются в `site-bff/src/main/resources/application.properties`.

Готовые HTTP-запросы для IntelliJ IDEA — в файле [`java-micro-restful-bff/http-requests.http`](java-micro-restful-bff/http-requests.http).

## Соответствие заданию

| Компонент | Endpoint | Статус |
|-----------|----------|--------|
| user-service | `GET /api/users/{userId}` | ✅ |
| order-service | `GET /api/orders/by-user/{user}` | ✅ |
| site-bff | `GET /api/site-bff/user/{userId}` | ✅ |

- Все три сервиса используют `@RestController` и `spring-boot-starter-web`.
- Модели `User`, `Order` и агрегат `UserSiteProfile` содержат требуемые поля.
- BFF обращается к user-service и order-service через HTTP-клиенты и **не хранит данные** локально.
- Интеграционные проверки (сборка + HTTP-запросы) пройдены успешно — подробности в [`Docs/verification-checklist.md`](Docs/verification-checklist.md).

## Пример ответа BFF

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
      "amount": 4599.00,
      "currency": "RUB",
      "items": ["Наушники", "Чехол для телефона"]
    }
  ]
}
```
