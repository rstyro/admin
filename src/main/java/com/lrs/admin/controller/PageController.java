package com.lrs.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/include/{pageName}")
	public String include(@PathVariable("pageName") String pageName){
		System.out.println("/include/"+pageName);
		return "include/"+pageName;
	}
	
}
