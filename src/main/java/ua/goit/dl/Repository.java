package ua.goit.dl;

public interface Repository<T> {

    T findById(Integer id);

    void create(T t);

    void delete(T t);

    int update(T t);

}
