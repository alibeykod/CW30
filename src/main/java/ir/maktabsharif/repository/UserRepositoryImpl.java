package ir.maktabsharif.repository;

import ir.maktabsharif.dao.UserDAO;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class UserRepositoryImpl implements UserRepo{
    @Override
    public UserDAO create(UserDAO userDAO) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(userDAO);
            return userDAO;
        });
    }

    @Override
    public UserDAO update(UserDAO userDAO) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.merge(userDAO);
            return userDAO;
        });
    }

    @Override
    public List<UserDAO> findAll() {
        return HibernateUtil.read(entityManager -> {
            List<UserDAO> users = entityManager.createQuery("SELECT u FROM UserDAO u" , UserDAO.class).getResultList();
            return users;
        });
    }

    @Override
    public UserDAO findById(Long id) {
        return HibernateUtil.read(entityManager -> {
           UserDAO userFound =  entityManager.find(UserDAO.class , id);
           return userFound;
        });
    }

    @Override
    public void delete(Long id) {
        HibernateUtil.read(entityManager -> {
            UserDAO found = entityManager.find(UserDAO.class , id);
            entityManager.remove(found);
            return id;
        });
    }
}
