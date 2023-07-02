package techworld.spring.boot.crud.springbootcrudapp.service;

import techworld.spring.boot.crud.springbootcrudapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    User updateUser(User user);

    void deleteUser(Long userId);
}
