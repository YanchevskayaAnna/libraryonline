package service;

import dao.interfaces.AuthorDAO;
import dao.interfaces.BookDAO;
import exception.TableIsEmptyException;
import model.Author;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
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
    public List<Book> getAllBooks() throws TableIsEmptyException {
        return bookDAO.getAll();
    }

    public List<Book> getBooksByAuthor(Author author) throws TableIsEmptyException {
        return bookDAO.findByAuthor(author);
    }

    public List<Book> getBooksByName(String bookName) throws TableIsEmptyException {
        return bookDAO.findByName(bookName);
    }

    public Book getBookByAuthorName(Author author, String bookName) throws TableIsEmptyException {
        return bookDAO.findByNameAuthor(bookName, author);
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

    public File downloadBook(Book book) {
        return bookDAO.downloadBook(book);
    }

    public String readBook(Book book) throws FileNotFoundException {
        return bookDAO.readBook(book);
    }

    //AUTHORS
    public List<Author> getAllAuthors() throws TableIsEmptyException {
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
