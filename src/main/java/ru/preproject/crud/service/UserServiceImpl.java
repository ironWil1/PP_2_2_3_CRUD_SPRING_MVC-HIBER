package ru.preproject.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.preproject.crud.dao.UserDao;
import ru.preproject.crud.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao ;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public void updateUser(User user, long id) {
        userDao.updateUser(user, id);
    }

    @Override
    public List<User> getAll() {
        return userDao.showAllUsers();
    }
}
