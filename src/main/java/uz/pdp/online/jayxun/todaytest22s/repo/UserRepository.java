package uz.pdp.online.jayxun.todaytest22s.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.jayxun.todaytest22s.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByUsernameIgnoreCase(String username);

}