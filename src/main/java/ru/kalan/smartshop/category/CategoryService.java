package ru.kalan.smartshop.category;

import ru.kalan.smartshop.category.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    /**
     * Получение списка категорий товаров
     * @return Список DTO категорий
     */
    List<CategoryDto> findAllCategories();
}
