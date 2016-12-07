package dao.interfaces;
import exception.TableIsEmptyException;
import model.Author;
import model.Book;

import java.util.List;

public interface BookDAO extends AbstractDAO<Book>{
    List<Book> findByName(String Name) throws TableIsEmptyException;
    List<Book> findByAuthor(Author author) throws TableIsEmptyException;
    Book findByNameAuthor(String Name, Author author) throws TableIsEmptyException;
}
