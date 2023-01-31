package ru.kalan.smartshop.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kalan.smartshop.category.model.Category;
import ru.kalan.smartshop.product.dto.ProductDto;
import ru.kalan.smartshop.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

    public static ProductDto toDto(Product product) {
        final ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setCategories(product.getCategories().stream()
                .map(Category::getName)
                .collect(Collectors.toSet()));
        return productDto;
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
