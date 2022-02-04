package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.Exam05Repository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	@Autowired
	private Exam05Repository repository;
		
	@RequestMapping("")
	public String index() {
		return "exam05";
	}
	
	@RequestMapping("check")
	public String check(String word,Model model) {
		List<Member>member = repository.findByName(word);
		model.addAttribute("member",member);
		return "exam05-result";
	}
}
