package ru.kalan.smartshop.product.model;

import lombok.*;
import ru.kalan.smartshop.category.model.Category;
import ru.kalan.smartshop.order.model.Order;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @Column(nullable = false)
    private Double price;
}
