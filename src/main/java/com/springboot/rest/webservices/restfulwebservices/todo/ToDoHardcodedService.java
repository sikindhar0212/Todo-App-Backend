package com.springboot.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoHardcodedService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static long idCounter = 0;

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);

        if (todo == null) {
            return null;
        }

        if(todos.remove(todo)){
            return todo;
        } else {
            return null;
        } 
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1) {
            todo.setId(++idCounter);
            todos.add(todo);
            return todo;
        } else if (todo.getId() > 0) {
            Todo existingTodo = findById(todo.getId());
            if (existingTodo != null) {
                existingTodo.setDescription(todo.getDescription());
                existingTodo.setTargetDate(todo.getTargetDate());
                existingTodo.setDone(todo.isDone());
                return existingTodo;
            }
        }
        return null;
    }

    public Todo create(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
            return todo;
        }
        return null;
    }
}
