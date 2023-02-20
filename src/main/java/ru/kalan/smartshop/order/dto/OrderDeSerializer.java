package ru.kalan.smartshop.order.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

@Slf4j
public class OrderDeSerializer implements Deserializer<NewOrderDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public NewOrderDto deserialize(String s, byte[] bytes) {
        try {
            return objectMapper.readValue(new String(bytes), NewOrderDto.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
