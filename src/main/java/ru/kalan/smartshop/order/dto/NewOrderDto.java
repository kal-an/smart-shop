package ru.kalan.smartshop.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.kalan.smartshop.order.model.Status;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Сущность заказа")
public class NewOrderDto {

    @Schema(description = "Список продуктов")
    private List<Long> products;

    @Schema(description = "Номер карты")
    private String cartNumber;

    @Schema(description = "ID пользователя")
    private Long userId;

    @Schema(description = "Статус")
    private String status;
}
