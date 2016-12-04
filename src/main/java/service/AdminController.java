package service;

import dao.interfaces.AuthorDAO;
import dao.interfaces.BookDAO;
import model.Author;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminController {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorDAO authorDAO;

    public AdminController() {
    }

    //BOOKS
    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }

    public Book getBookById(Integer id) {
        return bookDAO.getEntityById(id);
    }

    public boolean updateBook(Book book) {
        return bookDAO.update(book);
    }

    public Book createBook(Book book) {
        return bookDAO.create(book);
    }

    public void deleteAllBooks() {
        bookDAO.deleteAll();
    }


    //AUTHORS
    public List<Author> getAllAuthors() {
        return authorDAO.getAll();
    }

    public Author getAuthorById(Integer id) {
        return authorDAO.getEntityById(id);
    }

    public boolean updateAuthor(Author author) {
        return authorDAO.update(author);
    }

    public Author createAuthor(Author author) {
        return authorDAO.create(author);
    }

    public void deleteAllAuthors() {
        authorDAO.deleteAll();
    }

}
