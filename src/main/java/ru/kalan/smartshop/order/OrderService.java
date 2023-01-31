package ru.kalan.smartshop.order;

import ru.kalan.smartshop.order.dto.NewOrderDto;
import ru.kalan.smartshop.order.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(NewOrderDto newDto);

    void cancelOrder(Long orderId);

    void payForOrder(Long orderId);

    void addProductToOrder(Long orderId, Long productId);

    OrderDto getById(Long orderId);
}
