package com.mhacard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mhacard.service.APIUserServiceImpl;

@Controller
@RequestMapping("/APIUser")
public class UserAPIController {
	
	@Autowired
	private APIUserServiceImpl apiUserServiceImpl;
	
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String apiUserIndex(RedirectAttributes flashMessage, HttpServletRequest request) {
		try {
			
			return "apiUser";
		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}
}
