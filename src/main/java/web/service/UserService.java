package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void add(User user);

    public List<User> getAllUsers();

    void delete(long id);

    void update(User user);

    User get(long id);
}
