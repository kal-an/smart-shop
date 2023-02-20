package ru.kalan.smartshop.order.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.backoff.FixedBackOff;
import ru.kalan.smartshop.order.dto.NewOrderDto;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OrderConsumer implements Consumer<List<NewOrderDto>> {

    private final OrderMessageProcessor messageProcessor;

    @Override
    @Transactional
    public void accept(List<NewOrderDto> newDto) {
        log.info("Message {} received", newDto);
        messageProcessor.processBatchOfMessages(newDto);
    }

    @Bean
    ListenerContainerCustomizer<AbstractMessageListenerContainer<?, ?>> customizer() {
        return (container, dest, group) -> {
            if (group.equals("order-consumer-group")) {
                container.setCommonErrorHandler(new DefaultErrorHandler(
                        new FixedBackOff(0, 0)));
            }
        };
    }
}
