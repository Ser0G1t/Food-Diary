package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Set;

@MappedSuperclass
public abstract class CoreEntity<T, S> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public abstract void update(T entity);
    @JsonIgnore
    public abstract List<S> getCollection();
    public abstract void addToCollection(S entity);
    public abstract void removeFromCollection(S entity);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
