package dao.interfaces;

import java.util.List;

public interface AbstractDAO<E> {

    List<E> getAll();

    E getEntityById(Integer id);

    boolean update(E entity);

    E create(E entity);

    boolean delete(E entity);

    public void deleteAll();

}
