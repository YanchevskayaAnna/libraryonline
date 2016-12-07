package dao;

import dao.interfaces.BookDAO;
import exception.TableIsEmptyException;
import model.Author;
import model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Book> getAll() throws TableIsEmptyException {
        TypedQuery<Book> namedQuery = manager.createNamedQuery("Book.getAll", Book.class);
        return namedQuery.getResultList();
    }

    @Override
    public Book getEntityById(Integer id) {
        return manager.find(Book.class, id);
    }

    @Override
    public boolean update(Book entity) {

        if (getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }

        return true;
    }

    @Override
    public Book create(Book entity) {
        manager.persist(entity);
        return entity;
    }

    @Override
    public boolean delete(Book entity) {
        manager.remove(entity);
        return true;
    }

    @Override
    public void deleteAll() {
        manager.createQuery("DELETE FROM Book b").executeUpdate();
    }

    @Override
    public List<Book> findByName(String name) throws TableIsEmptyException {

        String queryString = "SELECT b FROM Book b WHERE b.name = :bookName";
        TypedQuery<Book> query = manager.createQuery(queryString, Book.class);
        query.setParameter("bookName", name);
        List<Book> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<Book> findByAuthor(Author author) throws TableIsEmptyException {

        String queryString = "SELECT b FROM Book b join b.authorList a WHERE a.name = :authorName";
        TypedQuery<Book> query = manager.createQuery(queryString, Book.class);
        query.setParameter("authorName", author.getName());
        List<Book> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public Book findByNameAuthor(String name, Author author) throws TableIsEmptyException {

        String queryString = "SELECT b FROM Book b join b.authorList a WHERE a.name = :authorName and b.name = :bookName";
        TypedQuery<Book> query = manager.createQuery(queryString, Book.class);
        query.setParameter("authorName", author.getName());
        query.setParameter("bookName", name);

        return query.getSingleResult();

    }
}
