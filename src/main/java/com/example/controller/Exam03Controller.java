package com.example.controller;

import java.text.NumberFormat;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	@RequestMapping("/calc")
	public String calc(Integer num1,Integer num2,Integer num3) {
		NumberFormat comFormat = NumberFormat.getNumberInstance();
		application.setAttribute("tax_on", comFormat.format((num1+num2+num3) * 1.1));
		application.setAttribute("tax_off", comFormat.format(num1+num2+num3));
		return "exam03-result";
		}
	
}


