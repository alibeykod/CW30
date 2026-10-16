package ir.maktabsharif.repository;

import ir.maktabsharif.dao.BookDAO;
import ir.maktabsharif.util.HibernateUtil;

import java.awt.print.Book;
import java.util.List;

public class BookRepositoryImpl implements BookRepo {

    @Override
    public BookDAO create(BookDAO bookDAO) {
        return HibernateUtil.inTxReturn(entityManager -> {
                    entityManager.persist(bookDAO);
                    return bookDAO;
                }
        );
    }

    @Override
    public BookDAO update(BookDAO bookDAO) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.merge(bookDAO);
            return bookDAO;
        });
    }

    @Override
    public BookDAO findById(Long id) {
        return HibernateUtil.read(entityManager -> {
            BookDAO bookDAOFound = entityManager.find(BookDAO.class, id);
            return bookDAOFound;
        });
    }

    @Override
    public List<BookDAO> findAll() {
        return HibernateUtil.read(entityManager -> {
            List<BookDAO> books = entityManager.createQuery("SELECT b FROM BookDAO b" , BookDAO.class).getResultList();
            return books;
        });
    }

    @Override
    public void delete(Long id) {
       HibernateUtil.inTxReturn(entityManager -> {
          BookDAO bookDAOFound =   entityManager.find(BookDAO.class , id);
          entityManager.remove(bookDAOFound);
          return id;
        });
    }
}
