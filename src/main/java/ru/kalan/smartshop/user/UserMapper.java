package ru.kalan.smartshop.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kalan.smartshop.user.dto.UserDto;
import ru.kalan.smartshop.user.dto.UserShortDto;
import ru.kalan.smartshop.user.model.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserDto toDto(User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static UserShortDto toShortDto(User user) {
        final UserShortDto userDto = new UserShortDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        return userDto;
    }

    public static User toUser(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }
}
