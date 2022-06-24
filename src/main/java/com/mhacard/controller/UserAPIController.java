package com.mhacard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mhacard.model.APIUser;
import com.mhacard.service.APIUserServiceImpl;

@Controller
@RequestMapping("/APIUser")
public class UserAPIController {
	
	@Autowired
	private APIUserServiceImpl apiUserServiceImpl;
	
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String apiUserIndex(RedirectAttributes flashMessage, HttpServletRequest request, Model model) {
		try {
			model.addAttribute("users", apiUserServiceImpl.getAll());
			return "apiUser";
		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/store")
	public String storeUser(RedirectAttributes flashMessage, 
			HttpServletRequest request,
			@RequestParam("email")String email,
			@RequestParam("password")String password) {
		try {
			if(apiUserServiceImpl.getByEmail(email)==null) {
				APIUser user = new APIUser();
				user.setEmail(email);
				user.setPassword(password);
				apiUserServiceImpl.add(user);
				flashMessage.addFlashAttribute("success", "ສຳເລັດ");
				return "redirect:/APIUser/";
			}else {
				flashMessage.addFlashAttribute("flashError", "This email address already registered");
				return "redirect:" + request.getHeader("Referer");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/delete/{email}")
	public String deleteUser(
			RedirectAttributes flashMessage,
			HttpServletRequest request,
			@PathVariable("email")String email) {
		try {
			apiUserServiceImpl.delete(email);
			flashMessage.addFlashAttribute("success", "ສຳເລັດ");
			return "redirect:/APIUser/";
		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}
}
