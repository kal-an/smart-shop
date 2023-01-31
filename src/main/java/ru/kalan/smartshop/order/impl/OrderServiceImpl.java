package ru.kalan.smartshop.order.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.kalan.smartshop.exception.NotFoundEntityException;
import ru.kalan.smartshop.order.OrderMapper;
import ru.kalan.smartshop.order.OrderRepository;
import ru.kalan.smartshop.order.OrderService;
import ru.kalan.smartshop.order.dto.NewOrderDto;
import ru.kalan.smartshop.order.dto.OrderDto;
import ru.kalan.smartshop.order.model.Order;
import ru.kalan.smartshop.order.model.Status;
import ru.kalan.smartshop.product.ProductMapper;
import ru.kalan.smartshop.product.ProductService;
import ru.kalan.smartshop.product.dto.ProductDto;
import ru.kalan.smartshop.product.model.Product;
import ru.kalan.smartshop.user.UserMapper;
import ru.kalan.smartshop.user.UserService;
import ru.kalan.smartshop.user.dto.UserShortDto;

import java.util.List;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public OrderDto createOrder(NewOrderDto newDto) {
        final UserShortDto user = userService.getById(newDto.getUserId());
        final List<Product> products = productService.getProductByIds(newDto.getProducts())
                .stream()
                .map(ProductMapper::toProduct).toList();
        final Order savedOrder = orderRepository.save(
                Order.builder()
                        .cartNumber(newDto.getCartNumber())
                        .status(Status.NEW)
                        .products(products)
                        .user(UserMapper.toUser(user))
                        .build());
        log.info("Order {} created", savedOrder);
        return OrderMapper.toDto(savedOrder);
    }

    @Override
    public void cancelOrder(Long orderId) {
        final Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new NotFoundEntityException(String
                        .format("Order with id=%d was not found.", orderId)));
        if (!order.isCanceled()) {
            order.setStatus(Status.CANCELED);
            orderRepository.save(order);
            log.info("Order {} canceled", orderId);
        }
    }

    @Override
    public void payForOrder(Long orderId) {
        final Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new NotFoundEntityException(String
                        .format("Order with id=%d was not found.", orderId)));
        if (order.isCreated()) {
            order.setStatus(Status.COMPLETE);
            orderRepository.save(order);
            log.info("Order {} paid", orderId);
        }
    }

    @Override
    public OrderDto addProductToOrder(Long orderId, Long productId) {
        final Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new NotFoundEntityException(String
                        .format("Order with id=%d was not found.", orderId)));
        final ProductDto productDto = productService.getById(productId);
        if (order.isCreated()) {
            final List<Product> products = order.getProducts();
            products.add(ProductMapper.toProduct(productDto));
            orderRepository.save(order);
            log.info("Added product {} to order {}", productId, orderId);
        }
        return OrderMapper.toDto(order);
    }

    @Override
    public OrderDto getById(Long orderId) {
        final Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new NotFoundEntityException(String
                        .format("Order with id=%d was not found.", orderId)));
        return OrderMapper.toDto(order);
    }
}
