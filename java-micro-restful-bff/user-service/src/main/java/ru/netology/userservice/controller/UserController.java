package ru.netology.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.userservice.model.User;
import ru.netology.userservice.service.UserService;

/**
 * REST-контроллер микросервиса пользователей.
 * Endpoint: GET /api/users/{userId}
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Возвращает информацию о пользователе по идентификатору.
     *
     * @param userId идентификатор пользователя
     * @return модель пользователя
     */
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
}
