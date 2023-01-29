package ru.kalan.smartshop.user;

import ru.kalan.smartshop.user.dto.UserDto;
import ru.kalan.smartshop.user.dto.UserShortDto;

public interface UserService {

    UserShortDto createUser(UserDto newDto);
}
