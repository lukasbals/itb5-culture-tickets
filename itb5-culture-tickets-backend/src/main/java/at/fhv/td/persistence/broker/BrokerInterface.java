package at.fhv.td.persistence.broker;

import at.fhv.td.persistence.PersistenceFilter;

import java.util.List;

public interface BrokerInterface<T> {
    List<T> getAll();

    List<T> getAll(List<PersistenceFilter> conditions);

    T get(Long id);

    Long save(T item);

    List<T> saveMultiple(List<T> items);

    void update(T item);

    void delete(T item);
}