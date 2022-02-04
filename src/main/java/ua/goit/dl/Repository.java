package ua.goit.dl;

public interface Repository<T> {



    void create(T t);

    void remove(T t);

    int update(T t);

}
