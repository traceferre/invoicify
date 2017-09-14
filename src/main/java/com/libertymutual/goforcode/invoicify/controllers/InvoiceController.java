package com.libertymutual.goforcode.invoicify.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {
	
	@GetMapping("")
	public ModelAndView seeInvoices(Authentication auth) {
		User user = (User) auth.getPrincipal();
		ModelAndView mv = new ModelAndView("invoice/list");
		mv.addObject("user", user);
		return mv;
	}
	
	
	

}
