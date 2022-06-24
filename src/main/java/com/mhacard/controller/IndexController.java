package com.mhacard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	
	@RequestMapping(method = RequestMethod.GET, value="/home")
	public String index() {
		return "home";
	}
}
