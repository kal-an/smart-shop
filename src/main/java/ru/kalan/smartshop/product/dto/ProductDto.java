package ru.kalan.smartshop.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.kalan.smartshop.category.dto.CategoryDto;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Сущность продукта")
public class ProductDto {

    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Название")
    private String title;

    @Schema(description = "Список категорий")
    private Set<String> categories;

    @Schema(description = "Цена")
    private Double price;
}
