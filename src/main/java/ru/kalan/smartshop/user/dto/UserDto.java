package ru.kalan.smartshop.user.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import ru.kalan.smartshop.validation.OnCreate;
import ru.kalan.smartshop.validation.OnUpdate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    @Null(groups = OnCreate.class, message = "ID should be empty")
    @NotNull(groups = OnUpdate.class, message = "ID should not be empty")
    private Integer id;

    @NotBlank(message = "Name should not be empty")
    @Size(max = 30, message = "Name should less 30 characters")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be empty")
    @Size(max = 30, message = "Email should less 30 characters")
    private String email;
}
