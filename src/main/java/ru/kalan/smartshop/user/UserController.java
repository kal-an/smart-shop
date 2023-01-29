package ru.kalan.smartshop.user;

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
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserDto createUser(
            @Validated(OnCreate.class) @RequestBody UserDto newDto) {
        log.info("Add new user {}", newDto);
        return userService.createUser(newDto);
    }
}
