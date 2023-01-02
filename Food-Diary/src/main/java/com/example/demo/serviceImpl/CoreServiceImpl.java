package com.example.demo.serviceImpl;

import com.example.demo.entity.CoreEntity;
import com.example.demo.repository.CoreRepository;
import com.example.demo.service.CoreService;

import java.util.List;
import java.util.Set;

public abstract class CoreServiceImpl<T extends CoreEntity,S> implements CoreService<T,S> {

    private final CoreRepository<T> repository;
    private final CoreRepository<S> secondaryRepository;

    public CoreServiceImpl(CoreRepository<T> repository, CoreRepository<S> secondaryRepository){
        this.repository=repository;
        this.secondaryRepository=secondaryRepository;
    }

    @Override
    public void create(T entity) {
        repository.save(entity);
    }

    @Override
    public void update(T entity) {
        T toUpdate=repository.findById(entity.getId())
                .orElseThrow(()->new NullPointerException("no value with this id"));
        toUpdate.update(entity);
        repository.save(toUpdate);
    }

    @Override
    public void remove(long id) {
        T toUpdate=repository.findById(id)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        repository.delete(toUpdate);
    }

    @Override
    public List<S> getCollection(long id) {
        T entity= repository.findById(id)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        return entity.getCollection();
    }

    @Override
    public void addToCollection(long entityId, long addedEntityId) {
        T entity= repository.findById(entityId)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        S addedEntity=secondaryRepository.findById(addedEntityId)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        entity.addToCollection(addedEntity);
        repository.save(entity);
    }

    @Override
    public void removeFromCollection(long entityId, long removedEntityId) {
        T entity= repository.findById(entityId)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        S removedEntity=secondaryRepository.findById(removedEntityId)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        entity.removeFromCollection(removedEntity);
        repository.save(entity);
    }
}
