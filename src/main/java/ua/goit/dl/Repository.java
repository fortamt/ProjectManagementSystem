package ua.goit.dl;

public interface Repository<T> {

    T findById(Integer id);

    void create(T t);

    void remove(T t);

    int update(T t);

}
