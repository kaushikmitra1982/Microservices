package techworld.spring.boot.crud.springbootcrudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techworld.spring.boot.crud.springbootcrudapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
