package com.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestfulController {
	
	
	 
	@RequestMapping
	public ModelAndView welcome(){
		System.out.println("in welcome ");
		return new ModelAndView("Welcome");
		
	}

}
