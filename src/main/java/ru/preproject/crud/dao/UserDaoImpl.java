package ru.preproject.crud.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.preproject.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        em.remove(getUser(id));
    }

    @Override
    public User getUser(long id) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.id = ?1", User.class);
        return query.setParameter(1, id).getSingleResult();
    }
    @Transactional
    @Override
    public void updateUser(User user, long id) {
        User updatedUser = new User();
        em.detach(getUser(id));
        updatedUser.setId(id);
        updatedUser.setName(user.getName());
        updatedUser.setSurName(user.getSurName());
        updatedUser.setAccountBalance(user.getAccountBalance());
        em.merge(updatedUser);
    }

    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u", User.class);
        return  query.getResultList();
    }
}
