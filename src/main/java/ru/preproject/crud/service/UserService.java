package ru.preproject.crud.service;

import ru.preproject.crud.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    void updateUser(User user, long id);
    List<User> getAll();
}
