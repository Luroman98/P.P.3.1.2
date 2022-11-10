package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUser(Long id);
    void update(Long id, User updateUser);
    void deleteUser(Long id);
}
