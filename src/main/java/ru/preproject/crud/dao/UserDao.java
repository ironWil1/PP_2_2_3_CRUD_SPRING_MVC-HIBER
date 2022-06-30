package ru.preproject.crud.dao;

import ru.preproject.crud.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void deleteUser(long id);

    User getUser(long id);

    void updateUser(User user);

    List<User> showAllUsers();
}
