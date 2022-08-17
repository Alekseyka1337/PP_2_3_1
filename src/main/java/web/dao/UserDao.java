package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void add(User user);

    void delete(long id);

    void update(User user);

    User get(long id);

}
