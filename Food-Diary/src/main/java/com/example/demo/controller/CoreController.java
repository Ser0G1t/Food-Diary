package com.example.demo.controller;

import com.example.demo.service.CoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

public abstract class CoreController<T,S>{
    private static final String CREATE="create";
    private static final String UPDATE="update";
    private static final String DELETE="delete/{id}";
    private static final String GET_COLLECTION="{id}/get_collection";
    private static final String ADD_TO_COLLECTION="{entityId}/add_to_collection/{addedEntityId}";
    private static final String REMOVE_FROM_COLLECTION="{entityId}/remove_from_collection/{removedEntityId}";

    private final CoreService<T,S> service;

    public CoreController(CoreService<T,S> service){
        this.service=service;
    }
    @PostMapping(CREATE)
    public ResponseEntity<T> create(@RequestBody T entity) {
        service.create(entity);
        return ResponseEntity.ok().build();
    }
    @PutMapping(UPDATE)
    public ResponseEntity<T> update(@RequestBody T entity) {
        service.update(entity);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<T> remove(@PathVariable long id) {
        service.remove(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(GET_COLLECTION)
    public ResponseEntity<List<S>> getCollection(@PathVariable long id) {
        return ResponseEntity.ok().body(service.getCollection(id));
    }
    @PostMapping(ADD_TO_COLLECTION)
    public ResponseEntity<T> addToCollection(@PathVariable long entityId, @PathVariable long addedEntityId) {
        service.addToCollection(entityId,addedEntityId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(REMOVE_FROM_COLLECTION)
    public ResponseEntity<T> removeFromCollection(@PathVariable long entityId,@PathVariable long removedEntityId) {
        service.removeFromCollection(entityId,removedEntityId);
        return ResponseEntity.ok().build();
    }

}
