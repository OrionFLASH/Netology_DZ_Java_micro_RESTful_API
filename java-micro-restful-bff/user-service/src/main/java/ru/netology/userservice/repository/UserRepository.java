package ru.netology.userservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.userservice.model.User;

import java.util.Map;
import java.util.Optional;

/**
 * In-memory хранилище пользователей для учебного задания.
 * В реальном проекте данные загружались бы из БД или внешнего источника.
 */
@Repository
public class UserRepository {

    /** Тестовые данные пользователей, ключ — идентификатор */
    private final Map<Long, User> users = Map.of(
            1L, new User(1L, "Иванов Иван Иванович", "г. Москва, ул. Ленина, д. 10", "+7-900-111-22-33", "ivanov@example.com"),
            2L, new User(2L, "Петрова Анна Сергеевна", "г. Санкт-Петербург, пр. Невский, д. 25", "+7-900-444-55-66", "petrova@example.com"),
            3L, new User(3L, "Сидоров Пётр Александрович", "г. Казань, ул. Баумана, д. 5", "+7-900-777-88-99", "sidorov@example.com")
    );

    /**
     * Поиск пользователя по идентификатору.
     *
     * @param userId идентификатор пользователя
     * @return пользователь, если найден
     */
    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(users.get(userId));
    }
}
