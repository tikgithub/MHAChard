package com.mhacard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mhacard.service.LoginServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@RequestMapping(method=RequestMethod.GET, value={"/login","/"})
	public String loginPage(RedirectAttributes flash,HttpServletRequest req) {
		//System.out.println(req.getAttribute("flashError"));
		//flash.addFlashAttribute("message", req.getAttribute("flashError"));
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String auth(RedirectAttributes flashMessage, HttpServletRequest request,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			HttpSession session) {
		try {
			String loginFlag = loginService.restAuthentication(email, password);
			if(loginFlag=="1") {
				session.setAttribute("userLogin", email);
				return "redirect:/home";
			}else {
				flashMessage.addFlashAttribute("flashError", "Username and Password may not correct, Please try again");
				return "redirect:" + request.getHeader("Referer");
			}

		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/logout")
	public String logOut(RedirectAttributes flashMessage, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			if(session!=null) {
				session.invalidate();
			}
			return "redirect:/login";
		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}
}
