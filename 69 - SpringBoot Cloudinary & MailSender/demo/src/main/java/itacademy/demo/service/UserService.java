package itacademy.demo.service;

import itacademy.demo.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Long id);
    User getByLogin(String login);
    List<User> getAll();
    User update(User user);
    Boolean dropPassword(Long id);
    Boolean logIn(String login, String password);
}
