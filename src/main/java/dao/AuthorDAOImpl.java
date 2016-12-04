package dao;

import dao.interfaces.AuthorDAO;
import model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> namedQuery = manager.createNamedQuery("Author.getAll", Author.class);
        return namedQuery.getResultList();
    }

    @Override
    public Author getEntityById(Integer id) {
        return manager.find(Author.class, id);
    }

    @Override
    public boolean update(Author entity) {

        if (getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }

        return true;
    }

    @Override
    public Author create(Author entity) {

        manager.persist(entity);
        return entity;

    }

    @Override
    public boolean delete(Author entity) {
        manager.remove(entity);
        return true;
    }

    @Override
    public void deleteAll() {
        manager.createQuery("DELETE FROM Author a").executeUpdate();
    }
}
