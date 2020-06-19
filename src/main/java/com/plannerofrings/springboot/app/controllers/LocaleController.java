package com.plannerofrings.springboot.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*Responsible for handling the response of the language change
    and redirect to the last page we were on after changing the language
   The last page we get through the request that we get the header and through
   of the header the last URL that would be the referer parameter*/
@Controller
public class LocaleController {

	// Will return the path to redirect to the last page
	@GetMapping("/locale")
	public String locale(HttpServletRequest request) {
		// Referer is the reference of the last url (link of the last page)
		String ultimaUrl = request.getHeader("referer");

		return "redirect:".concat(ultimaUrl);
	}
}
