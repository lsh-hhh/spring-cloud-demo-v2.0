package my.lsh.cloud.base.service;

public interface BaseService<T> {

    int create(T t);

    T findOne(Long id);

    T update(T t);
}
