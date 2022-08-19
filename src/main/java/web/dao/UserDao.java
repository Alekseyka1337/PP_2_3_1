package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void createUser(User user);

    void deleteUserById(long id);

    void updateUser(User user);

    User getUserById(long id);

}
