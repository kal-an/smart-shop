package ru.kalan.smartshop.order;

import ru.kalan.smartshop.order.dto.NewOrderDto;
import ru.kalan.smartshop.order.dto.OrderDto;

public interface OrderService {

    /**
     * Создание заказа
     * @param newDto DTO для создания нового заказа
     * @return DTO с сохраненным заказом
     */
    OrderDto createOrder(NewOrderDto newDto);

    /**
     * Создание заказа с отправкой в kafka
     * @param newDto DTO для создания нового заказа
     */
    void creatTaskNewOrder(NewOrderDto newDto);

    /**
     * Отмена заказ
     * @param orderId Идентификатор заказа
     */
    void cancelOrder(Long orderId);

    /**
     * Оплата заказа
     * @param orderId Идентификатор заказа
     */
    void payForOrder(Long orderId);

    /**
     * Добавление товаров дополнительно к заказу
     * @param orderId Идентификатор заказа
     * @param productId Идентификатор товара
     */
    void addProductToOrder(Long orderId, Long productId);

    /**
     * Получить DTO созданного заказа
     * @param orderId
     * @return DTO заказа
     */
    OrderDto getById(Long orderId);
}
