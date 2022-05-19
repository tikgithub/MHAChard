package com.mhacard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	
	@GetMapping("/rest")
	public @ResponseBody String index() {
		System.out.println("RestOK");
		return "Response OK";
	}
}
