package ir.maktabsharif.repository;

import ir.maktabsharif.dao.BookDAO;

import java.util.List;

public interface BookRepo {
    BookDAO create(BookDAO bookDAO);
    BookDAO update(BookDAO bookDAO);
    BookDAO findById(Long id);
    List<BookDAO> findAll();
    void delete(Long id);


}
