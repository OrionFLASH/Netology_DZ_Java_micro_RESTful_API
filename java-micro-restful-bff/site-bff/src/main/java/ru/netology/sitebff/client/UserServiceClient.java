package ru.netology.sitebff.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.sitebff.client.dto.UserDto;

/**
 * HTTP-клиент для получения данных пользователя из user-service.
 */
@Component
public class UserServiceClient {

    private final RestClient restClient;

    public UserServiceClient(@Qualifier("userServiceRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * Запрашивает профиль пользователя по идентификатору.
     *
     * @param userId идентификатор пользователя
     * @return данные пользователя
     */
    public UserDto getUserById(Long userId) {
        try {
            return restClient.get()
                    .uri("/api/users/{userId}", userId)
                    .retrieve()
                    .body(UserDto.class);
        } catch (HttpClientErrorException.NotFound notFound) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Пользователь с id=" + userId + " не найден"
            );
        }
    }
}
