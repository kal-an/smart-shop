package ru.kalan.smartshop.product.model;

import lombok.*;
import ru.kalan.smartshop.category.model.Category;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "categories")
    private Set<Category> categories;

    @Column(nullable = false)
    private Double price;
}
