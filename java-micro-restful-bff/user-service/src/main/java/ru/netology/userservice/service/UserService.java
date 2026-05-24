package ru.netology.userservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.userservice.model.User;
import ru.netology.userservice.repository.UserRepository;

/**
 * Сервисный слой для работы с пользователями.
 * Делегирует чтение данных репозиторию и обрабатывает отсутствие записи.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Возвращает пользователя по идентификатору или выбрасывает 404.
     *
     * @param userId идентификатор пользователя
     * @return найденный пользователь
     */
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Пользователь с id=" + userId + " не найден"
                ));
    }
}
