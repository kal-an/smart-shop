package ru.kalan.smartshop.order.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kalan.smartshop.order.OrderService;
import ru.kalan.smartshop.order.dto.NewOrderDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderMessageProcessor {

    private final OrderService orderService;

    public void processMessage(NewOrderDto newDto) {
        orderService.createOrder(newDto);
    }

    public void processBatchOfMessages(List<NewOrderDto> dtoList) {
        dtoList.forEach(orderService::createOrder);
    }
}
