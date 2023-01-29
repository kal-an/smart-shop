package ru.kalan.smartshop.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import ru.kalan.smartshop.validation.OnCreate;
import ru.kalan.smartshop.validation.OnUpdate;

import java.time.LocalDateTime;

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
    @Schema(description = "Идентификатор", example = "1234",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @NotBlank(message = "Name should not be empty")
    @Size(max = 30, message = "Name should less 30 characters")
    @Schema(description = "Имя")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be empty")
    @Size(max = 30, message = "Email should less 30 characters")
    @Schema(description = "Email")
    private String email;

    @Schema(description = "Дата регистрации",
            accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime regDate = LocalDateTime.now();
}
