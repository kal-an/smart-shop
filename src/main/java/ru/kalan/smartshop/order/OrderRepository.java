package ru.kalan.smartshop.order;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kalan.smartshop.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
