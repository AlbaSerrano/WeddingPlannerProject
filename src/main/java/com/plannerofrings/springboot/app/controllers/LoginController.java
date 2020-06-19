package com.plannerofrings.springboot.app.controllers;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*SPRING LOGIN CONTROLLER CLASS*/
@Controller
public class LoginController {

	@Autowired
	private MessageSource messageSource;

	/*
	 * the Principal object contains the logged in user so we can validate if the
	 * user was logged in or not
	 * 
	 * @RequestParam error contains the value of the error attribute that it sends
	 * us SpringSecurity when there is a login error, it is not required only when
	 * there are mistakes
	 * 
	 * @RequestParam logout contains the value of the logout attribute that it sends
	 * us Spring Security when logged out
	 */
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash, Locale locale) {

		// If the user was already logged in

		if (principal != null) {
			// Redirect to the main page to avoid login two times a la pagina de inicio par
			// evitar que se loguee 2 veces
			return "redirect:/";
		}

		// If there are errors in the login
		if (error != null) {
			model.addAttribute("title", messageSource.getMessage("text.title.error", null, locale));
			model.addAttribute("err", messageSource.getMessage("text.login.error", null, locale));
		}

		// render the login view
		return "login";
	}
}
