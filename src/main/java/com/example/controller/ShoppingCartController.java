package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/shop")
public class ShoppingCartController {
	@Autowired
	public ServletContext application;
	
	@Autowired
	private HttpSession session;
		
	@RequestMapping("")
	@SuppressWarnings("unchecked")
	public String index(Model model) {
		List<Item> itemList = (List<Item>) application.getAttribute("itemList");
		if (itemList == null) {
			itemList = new LinkedList<>();
			Item item = new Item();
			item.setName("手帳ノート");
			item.setPrice(1000);
			itemList.add(item);
			
			item.setName("文房具セット");
			item.setPrice(1500);
			itemList.add(item);
			
			item.setName("ファイル");
			item.setPrice(2000);
			itemList.add(item);

		}
		application.setAttribute("itemList", itemList);
		

		List<Item> emptyList = (List<Item>) session.getAttribute("emptyList");
		if (emptyList == null) {
			emptyList = new LinkedList<>();
		}
		session.setAttribute("emptyList", emptyList);
		
		int totalCost = 0;
		for ( Item itemPrice : emptyList){
			  totalCost = totalCost + itemPrice.getPrice();
		}
		model.addAttribute("totalCost",totalCost);
		
		return "item-and-cart";
	}
	
	@RequestMapping("/inCart")
	@SuppressWarnings("unchecked")
	public String inCart(Integer number) {
		List<Item> itemList = (List<Item>) application.getAttribute("emptyList");
		List<Item> emptyList = (List<Item>) session.getAttribute("emptyList");
		emptyList.add(itemList.get(number));
		return "/index";
	}
	
	@RequestMapping("/delete")
	@SuppressWarnings("unchecked")
	public String delete(Integer number) {
		List<Item> emptyList = (List<Item>) session.getAttribute("emptyList");
		emptyList.remove(number);
		return "/index";
	}
}
