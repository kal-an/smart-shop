package ru.kalan.smartshop.order;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kalan.smartshop.order.dto.OrderDto;
import ru.kalan.smartshop.order.model.Order;
import ru.kalan.smartshop.product.ProductMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static OrderDto toDto(Order order) {
        final OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCartNumber(order.getCartNumber());
        orderDto.setProducts(ProductMapper.toDtoList(order.getProducts()));
        orderDto.setUserId(order.getUser().getId());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }

    public static Order toOrder(OrderDto dto) {
        return Order.builder()
                .id(dto.getId())
                .cartNumber(dto.getCartNumber())
                .build();
    }
}
