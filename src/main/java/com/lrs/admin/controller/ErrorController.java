package com.lrs.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping("/error/{pageNumber}")
	public String error400(@PathVariable("pageNumber") String pageNumber){
		return "error/"+pageNumber;
	}
}
