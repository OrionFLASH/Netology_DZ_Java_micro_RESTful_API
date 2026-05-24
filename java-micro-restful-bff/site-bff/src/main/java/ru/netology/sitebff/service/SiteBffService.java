package ru.netology.sitebff.service;

import org.springframework.stereotype.Service;
import ru.netology.sitebff.client.OrderServiceClient;
import ru.netology.sitebff.client.UserServiceClient;
import ru.netology.sitebff.client.dto.OrderDto;
import ru.netology.sitebff.client.dto.UserDto;
import ru.netology.sitebff.model.UserSiteProfile;

import java.util.List;

/**
 * Сервис агрегации данных BFF.
 * Не хранит данные — последовательно запрашивает user-service и order-service,
 * затем собирает единый ответ для клиента.
 */
@Service
public class SiteBffService {

    private final UserServiceClient userServiceClient;
    private final OrderServiceClient orderServiceClient;

    public SiteBffService(UserServiceClient userServiceClient, OrderServiceClient orderServiceClient) {
        this.userServiceClient = userServiceClient;
        this.orderServiceClient = orderServiceClient;
    }

    /**
     * Формирует агрегированный профиль пользователя с заказами.
     *
     * @param userId идентификатор пользователя
     * @return объединённые данные пользователя и заказов
     */
    public UserSiteProfile getUserProfile(Long userId) {
        UserDto user = userServiceClient.getUserById(userId);
        List<OrderDto> orders = orderServiceClient.getOrdersByUserId(userId);

        List<UserSiteProfile.OrderSummary> orderSummaries = orders.stream()
                .map(order -> new UserSiteProfile.OrderSummary(
                        order.id(),
                        order.amount(),
                        order.currency(),
                        order.items()
                ))
                .toList();

        return new UserSiteProfile(
                user.id(),
                user.fullName(),
                user.deliveryAddress(),
                user.phone(),
                user.email(),
                orderSummaries
        );
    }
}
