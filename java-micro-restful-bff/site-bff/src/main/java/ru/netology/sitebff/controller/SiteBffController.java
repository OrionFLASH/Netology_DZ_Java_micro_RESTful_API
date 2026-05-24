package ru.netology.sitebff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sitebff.model.UserSiteProfile;
import ru.netology.sitebff.service.SiteBffService;

/**
 * REST-контроллер BFF-микросервиса.
 * Endpoint: GET /api/site-bff/user/{userId}
 */
@RestController
@RequestMapping("/api/site-bff")
public class SiteBffController {

    private final SiteBffService siteBffService;

    public SiteBffController(SiteBffService siteBffService) {
        this.siteBffService = siteBffService;
    }

    /**
     * Возвращает агрегированный профиль пользователя и его заказы.
     *
     * @param userId идентификатор пользователя
     * @return объединённые данные для клиентского приложения
     */
    @GetMapping("/user/{userId}")
    public UserSiteProfile getUserProfile(@PathVariable Long userId) {
        return siteBffService.getUserProfile(userId);
    }
}
