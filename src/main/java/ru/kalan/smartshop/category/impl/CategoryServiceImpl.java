package ru.kalan.smartshop.category.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kalan.smartshop.category.CategoryMapper;
import ru.kalan.smartshop.category.CategoryRepository;
import ru.kalan.smartshop.category.CategoryService;
import ru.kalan.smartshop.category.dto.CategoryDto;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAllCategories() {
        return CategoryMapper.toDtoList(categoryRepository.findAll());
    }
}
