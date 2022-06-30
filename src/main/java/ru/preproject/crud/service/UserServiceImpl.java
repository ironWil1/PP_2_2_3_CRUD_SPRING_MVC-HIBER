package ru.preproject.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.preproject.crud.dao.UserDao;
import ru.preproject.crud.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void saveUser(User user) {
        if (user.getId() != null) {
            userDao.updateUser(user);
        } else {
            userDao.saveUser(user);
        }
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.showAllUsers();
    }
}
