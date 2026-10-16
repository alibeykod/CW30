package ir.maktabsharif.repository;

import ir.maktabsharif.dao.UserDAO;

import java.util.List;

public interface UserRepo {
    UserDAO create(UserDAO userDAO);
    UserDAO update(UserDAO userDAO);
    List<UserDAO> findAll();
    UserDAO findById(Long id);
    void delete(Long id);
}
