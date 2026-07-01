package com.example.demo.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoAppMainController {
	
	@Autowired
	private RegisterService registerService;
	
	
	@GetMapping("/todo")
	public String login(Model model) {
		model.addAttribute("todoList",registerService.findAll());
		return "HomePage";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register/register";
	}
	
	@GetMapping("/todo/edit/{id}")
	public String edit(@PathVariable Long id,Model model) {
		model.addAttribute("todo",registerService.findById(id));
		return "register/edit";
	}
	
	@PostMapping("/todo")
	public String postRegister(ToDo todo) {
		registerService.register(todo);
		return "redirect:/todo";
	}
	
	@PostMapping("/todo/delete/{taskId}")
	public String postDelete(@PathVariable Long taskId) {
		registerService.delete(taskId);
		return "redirect:/todo";
	}
	
	@PostMapping("/todo/update")
	public String postUpdate(ToDo todo) {
		registerService.update(todo);
		return "redirect:/todo";
	}
	
	
	
	
}