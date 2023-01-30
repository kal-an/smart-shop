package ru.kalan.smartshop.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kalan.smartshop.product.dto.ProductDto;
import ru.kalan.smartshop.product.model.Product;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

    public static ProductDto toDto(Product product) {
        final ProductDto userDto = new ProductDto();
        userDto.setId(product.getId());
        userDto.setTitle(product.getTitle());
        return userDto;
    }

    public static Product toProduct(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .build();
    }

    public static List<ProductDto> toDtoList(Iterable<Product> products) {
        List<ProductDto> dtos = new ArrayList<>();
        for (Product product : products) {
            dtos.add(toDto(product));
        }
        return dtos;
    }
}
