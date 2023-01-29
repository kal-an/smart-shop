package ru.kalan.smartshop.user;

import ru.kalan.smartshop.user.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto newDto);
}
