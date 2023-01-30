package ru.kalan.smartshop.product;

import ru.kalan.smartshop.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> searchProduct(String text);

    ProductDto getById(Long productId);
}
