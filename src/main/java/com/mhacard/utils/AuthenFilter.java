package com.mhacard.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@WebFilter({
	"/home",
	"/logout",
	"/getCardDataByDocNumber",
	"/send_request_api_data",
	"/storeCardPrintData/*",
	"/storeCardPrintCompleted",
	"/printing_list/*",
	"/verify_print_data/*",
	"/showEditPage/*",
	"/updateDocstatus/*",
	"/deleteDocument/*",
	"/APIUser/*"
})
public class AuthenFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("URL Filter Start Working");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		if(session!=null) {
			if(session.getAttribute("userLogin")==null) {
				req.setAttribute("flashError", "UnAuthorize Access");
				RequestDispatcher rd =req.getRequestDispatcher("/login");
				rd.forward(request, response);
				//res.sendRedirect("/login");
			}
		}
		chain.doFilter(request, response);
	}

}
