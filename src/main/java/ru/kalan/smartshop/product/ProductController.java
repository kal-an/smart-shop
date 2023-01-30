package ru.kalan.smartshop.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kalan.smartshop.product.dto.ProductDto;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
@Validated
@Tag(name = "Продукты", description = "Управление продуктами")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "{productId}")
    @Operation(summary = "Получение продукта",
            description = "Пользволяет получить продукт по идентификатору")
    public ProductDto getProductById(@PathVariable("productId") Long productId) {
        return productService.getById(productId);
    }

    @GetMapping("/search")
    @Operation(summary = "Поиска продукта",
            description = "Пользволяет найти продукт по названию")
    public List<ProductDto> searchProducts(
            @RequestParam String text,
            @RequestParam(required = false, defaultValue = "0") @Min(0) Integer from,
            @RequestParam(required = false, defaultValue = "20") @Min(1) Integer size) {
        return productService.searchProduct(text, from, size);
    }

}
