package com.example.demo.mvc;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	@Autowired
	private RegisterRepository registerRepository;
	
	public void register(ToDo todo) {
		LocalDateTime now = LocalDateTime.now();
		
		todo.setCreatedAt(now);
		todo.setUpdatedAt(now);
		
		registerRepository.save(todo);
	}
	
	public Iterable<ToDo> findAll(){
		return registerRepository.findAll();
	}
	
	public ToDo findById(Long taskId) {
		return registerRepository.findById(taskId)
				.orElseThrow(() -> new RuntimeException("ToDo not found" + taskId));
	}
	
	public void delete(Long taskId) {
		registerRepository.deleteById(taskId);
	}
	
	public void update(ToDo todo) {
		ToDo oldTodo = findById(todo.getTaskId());
		
		oldTodo.setTaskName(todo.getTaskName());
		oldTodo.setDetail(todo.getDetail());
		oldTodo.setPriority(todo.getPriority());
		oldTodo.setTodoStatus(todo.getTodoStatus());
		oldTodo.setUpdatedAt(LocalDateTime.now());
		
		registerRepository.save(oldTodo);
	}
}
