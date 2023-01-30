package ru.kalan.smartshop.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.kalan.smartshop.order.model.Status;
import ru.kalan.smartshop.product.dto.ProductDto;
import ru.kalan.smartshop.product.model.Product;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Сущность заказа")
public class OrderDto {

    @Schema(description = "Идентификатор")
    private Integer id;

    @Schema(description = "Список продуктов")
    private List<ProductDto> products;

    @Schema(description = "Номер карты")
    private String cartNumber;

    @Schema(description = "Статус")
    private Status status;
}
