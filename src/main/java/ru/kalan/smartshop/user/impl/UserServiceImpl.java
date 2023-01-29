package ru.kalan.smartshop.user.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.kalan.smartshop.user.UserMapper;
import ru.kalan.smartshop.user.UserRepository;
import ru.kalan.smartshop.user.UserService;
import ru.kalan.smartshop.user.dto.UserDto;
import ru.kalan.smartshop.user.dto.UserShortDto;
import ru.kalan.smartshop.user.model.User;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserShortDto createUser(UserDto newDto) {
        final User user = UserMapper.toUser(newDto);
        final User savedUser = userRepository.save(user);
        log.info("User {} saved", savedUser);
        return UserMapper.toShortDto(savedUser);
    }
}
