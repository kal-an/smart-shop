package ru.kalan.smartshop.product.model;

import lombok.*;
import ru.kalan.smartshop.category.model.Category;
import ru.kalan.smartshop.order.model.Order;

import javax.persistence.*;
import java.util.List;
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
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    @Column(nullable = false)
    private Double price;
}
