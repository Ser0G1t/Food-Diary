package com.example.demo.service;
import java.util.List;


public interface CoreService<T,S> {
    void create(T entity);
    void update(T entity);
    void remove(long id);
    List<S> getCollection(long id);
    void addToCollection(long entityId, long addedEntityId);
    void removeFromCollection(long entityId, long removedEntityId);
}
