package com.devmaurizio.service;

import com.devmaurizio.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoService {

    @PersistenceContext
    EntityManager entityManager;

    public Todo createTodo(Todo todo){
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo){
        entityManager.merge(todo);
        return todo;
    }

    public Todo findTodoById(Long id){
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> getTodo() {
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
    }
}
