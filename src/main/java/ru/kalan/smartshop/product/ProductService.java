package ru.kalan.smartshop.product;

import ru.kalan.smartshop.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    /**
     * Поиск товара
     * @param text Название товара
     * @param from Начальное значение страницы
     * @param size Количетсво элементов
     * @return Список товаров
     */
    List<ProductDto> searchProduct(String text, Integer from, Integer size);

    /**
     * Получение DTO товара
     * @param productId Идентификатор товара
     * @return DTO товара
     */
    ProductDto getById(Long productId);

    /**
     * Получение списка товаров
     * @param productIds Список идентификаторов товаров
     * @return Список товаров
     */
    List<ProductDto> getProductByIds(List<Long> productIds);
}
