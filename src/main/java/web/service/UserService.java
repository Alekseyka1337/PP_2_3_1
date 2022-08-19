package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    List<User> getAllUsers();

    void deleteUserById(long id);

    void updateUser(User user);

    User getUserById(long id);
}
