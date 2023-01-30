package ru.kalan.smartshop.user.dto;

import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.kalan.smartshop.validation.OnCreate;
import ru.kalan.smartshop.validation.OnUpdate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Сущность пользователя")
public class UserDto {

    @Null(groups = OnCreate.class, message = "ID should be empty")
    @NotNull(groups = OnUpdate.class, message = "ID should not be empty")
    private Long id;

    @NotBlank(message = "Name should not be empty")
    @Size(max = 30, message = "Name should less 30 characters")
    @Schema(description = "Имя")
    private String name;

    @NotBlank(message = "Password should not be empty")
    @Size(max = 10, message = "Name should less 10 characters")
    @Schema(description = "Логин")
    private String login;

    @NotBlank(message = "Name should not be empty")
    @Size(max = 10, message = "Password should less 10 characters")
    @Schema(description = "Пароль")
    private String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be empty")
    @Size(max = 30, message = "Email should less 30 characters")
    @Schema(description = "Email")
    private String email;
}
