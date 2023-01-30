package ru.kalan.smartshop.category;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kalan.smartshop.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
