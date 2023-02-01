package ru.kalan.smartshop.category;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kalan.smartshop.category.dto.CategoryDto;
import ru.kalan.smartshop.category.model.Category;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryMapper {

    public static CategoryDto toDto(Category category) {
        final CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    public static Category toCategory(CategoryDto dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public static List<CategoryDto> toDtoList(Iterable<Category> categories) {
        List<CategoryDto> dtos = new ArrayList<>();
        for (Category category : categories) {
            dtos.add(toDto(category));
        }
        return dtos;
    }
}
