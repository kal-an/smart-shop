package ru.kalan.smartshop.user;

import ru.kalan.smartshop.user.dto.UserDto;
import ru.kalan.smartshop.user.dto.UserShortDto;

public interface UserService {

    /**
     * Создание пользователя
     * @param newDto DTO для нового пользователя
     * @return DTO созданного пользователя
     */
    UserShortDto createUser(UserDto newDto);

    /**
     * Полуение DTO пользователя
     * @param userId Идентификатор пользователя
     * @return DTO существующего пользователя
     */
    UserShortDto getById(Long userId);
}
