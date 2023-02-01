package ru.kalan.smartshop.order.model;

import lombok.*;
import ru.kalan.smartshop.product.model.Product;
import ru.kalan.smartshop.user.model.User;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column
    private String cartNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Transient
    public boolean isCreated() {
        return status.equals(Status.NEW);
    }

    @Transient
    public boolean isCanceled() {
        return status.equals(Status.CANCELED);
    }

    @Transient
    public boolean isComplete() {
        return status.equals(Status.COMPLETE);
    }
}
