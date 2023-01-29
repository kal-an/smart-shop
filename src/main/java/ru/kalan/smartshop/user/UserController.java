package ru.kalan.smartshop.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kalan.smartshop.user.dto.UserDto;
import ru.kalan.smartshop.validation.OnCreate;

@RestController
@Slf4j
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "Пользователи", description = "Управление пользователями")
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    @Operation(summary = "Регистрация пользователя",
            description = "Пользволяет зарегистрировать пользователя")
    public UserDto createUser(
            @Validated(OnCreate.class) @RequestBody UserDto newDto) {
        log.info("Add new user {}", newDto);
        return userService.createUser(newDto);
    }
}