package ru.kalan.smartshop.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kalan.smartshop.order.dto.NewOrderDto;
import ru.kalan.smartshop.order.dto.OrderDto;
import ru.kalan.smartshop.validation.OnCreate;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Slf4j
@RequestMapping(path = "/orders")
@RequiredArgsConstructor
@Validated
@Tag(name = "Заказы", description = "Управление заказами")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Создание заказа",
            description = "Позволяет создать заказ")
    public OrderDto createOrder(
            @Validated(OnCreate.class) @RequestBody NewOrderDto newDto) {
        return orderService.createOrder(newDto);
    }

    @PatchMapping(value = "{orderId}/cancel")
    @Operation(summary = "Отмена заказа",
            description = "Позволяет отменить заказ")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }

    @PatchMapping(value = "{orderId}/pay")
    @Operation(summary = "Оплата заказа",
            description = "Позволяет отменить заказ")
    public void payOrder(@PathVariable Long orderId) {
        orderService.payForOrder(orderId);
    }

    @GetMapping(value = "{orderId}")
    @Operation(summary = "Просмотреть заказ",
            description = "Позволяет посмотреть заказ")
    public void getOrder(@PathVariable Long orderId) {
        orderService.getById(orderId);
    }
}
