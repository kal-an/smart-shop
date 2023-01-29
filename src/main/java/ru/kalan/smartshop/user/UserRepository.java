package ru.kalan.smartshop.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kalan.smartshop.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
