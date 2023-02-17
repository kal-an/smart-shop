package ru.kalan.smartshop.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/kafka", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Создание заказа",
            description = "Позволяет создать заказ", hidden = true)
    public ResponseEntity<String> creatTaskNewOrder(
            @Validated(OnCreate.class) @RequestBody NewOrderDto newDto) {
        orderService.creatTaskNewOrder(newDto);
        return new ResponseEntity<>("New order added.", HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "{orderId}/cancel")
    @Operation(summary = "Отмена заказа",
            description = "Позволяет отменить заказ")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }

    @PatchMapping(value = "{orderId}/pay")
    @Operation(summary = "Оплата заказа",
            description = "Позволяет оплатить заказ")
    public void payOrder(@PathVariable Long orderId) {
        orderService.payForOrder(orderId);
    }

    @GetMapping(value = "{orderId}")
    @Operation(summary = "Просмотреть заказ",
            description = "Позволяет посмотреть заказ")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return orderService.getById(orderId);
    }

    @PatchMapping("/{orderId}/products/{productId}")
    @Operation(summary = "Добавить продукт",
            description = "Позволяет добавить продукт к заказу")
    public void addProductToOrder(
            @PathVariable @Parameter(description = "Идентификатор продукта")  Long productId,
            @PathVariable @Parameter(description = "Идентификатор заказа")  Long orderId) {
        orderService.addProductToOrder(orderId, productId);
    }
}
