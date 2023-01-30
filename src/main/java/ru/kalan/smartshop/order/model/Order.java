package ru.kalan.smartshop.order.model;

import lombok.*;
import ru.kalan.smartshop.product.model.Product;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "orders")
    private List<Product> products;

    @Column
    private String cartNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
