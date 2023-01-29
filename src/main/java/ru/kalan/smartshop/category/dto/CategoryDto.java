package ru.kalan.smartshop.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.kalan.smartshop.validation.OnCreate;
import ru.kalan.smartshop.validation.OnUpdate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Сущность категории")
public class CategoryDto {

    @Null(groups = OnCreate.class, message = "ID should be empty")
    @NotNull(groups = OnUpdate.class, message = "ID should not be empty")
    @Schema(description = "Идентификатор", example = "1234",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @NotBlank(message = "Name should not be empty")
    @Size(max = 30, message = "Name should less 30 characters")
    @Schema(description = "Название")
    private String name;

}
