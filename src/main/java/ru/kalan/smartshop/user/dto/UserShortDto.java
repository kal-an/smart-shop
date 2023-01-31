package ru.kalan.smartshop.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Сущность пользователя")
public class UserShortDto {

    @Schema(description = "Идентификатор", example = "1234",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Name should not be empty")
    @Size(max = 30, message = "Name should less 30 characters")
    @Schema(description = "Имя")
    private String name;
}
