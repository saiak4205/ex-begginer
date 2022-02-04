package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	
	@ModelAttribute
	public User setUpForm() {
		return new User();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam04";
	}

	@RequestMapping("/check")
	public String calc(User user,Model model) {
		User users = new User();
		users.setName(user.getName());
		users.setAge(user.getAge());
		users.setComment(user.getComment());
		model.addAttribute("user",users);
		return "exam04-result";
		}
	
}


