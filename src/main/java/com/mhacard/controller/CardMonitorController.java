package com.mhacard.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mhacard.service.CardPrintListServiceImpl;

@Controller
@RequestMapping("/cardmonitor")
public class CardMonitorController {

	@Autowired
	private CardPrintListServiceImpl cardPrintListServiceImpl;

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public String showSearchPage(RedirectAttributes flashMessage, HttpServletRequest request) {
		try {

			return "pageCardSearchMonitor";
		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/search")
	public String searchData(RedirectAttributes flashMessage, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes model, @RequestParam("document_number") String document_number) {
		try {

			model.addFlashAttribute("cardList", cardPrintListServiceImpl.getDataByDocumentNumber(document_number));
			model.addFlashAttribute("document_number",document_number);
			return "redirect:/cardmonitor/search";
		} catch (Exception e) {
			e.printStackTrace();
			flashMessage.addFlashAttribute("flashError", e.getMessage());
			return "redirect:" + request.getHeader("Referer");
		}
	}
}
