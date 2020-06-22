package com.javaegitimleri.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javaegitimleri.app.model.Transaction;
import com.javaegitimleri.app.service.TransactionService;

@Controller
public class MainController {

	@Autowired
	private TransactionService appservice;
	
	@RequestMapping("/login.html")
	public ModelAndView getLoginPage() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("messages", "Hello! .. This is Login Page");
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping("/")
	public String mainPage() {
		
		return "main";
	}
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		
		return "welcome";
	}
	
	
	
}
