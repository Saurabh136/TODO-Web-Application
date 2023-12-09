package com.udemy.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	static {
		  todos.add(new Todo(++todosCount,"udemy","Get AWS Certified 1", LocalDate.now().plusYears(1), false));
		  todos.add(new Todo(++todosCount,"udemy","Learn DevOps 1", LocalDate.now().plusYears(2), false));
		  todos.add(new Todo(++todosCount,"udemy","Learn Full Stack 1", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findbyUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username); //we check if username matches
		return todos.stream().filter(predicate).toList();// we use stream here coz if we have 10 todos , then each of them are process individually
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
    }
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
		
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		// TODO Auto-generated method stub
		
	}

}
