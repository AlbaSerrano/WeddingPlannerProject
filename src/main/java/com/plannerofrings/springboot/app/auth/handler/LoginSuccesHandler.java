package com.plannerofrings.springboot.app.auth.handler;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccesHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private LocaleResolver localeResolver;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// We use this form because we cannot use the RedirectAttributes

		// Map manager for Flash messages
		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();

		FlashMap flashMap = new FlashMap();

		// Obtain the locale
		Locale locale = localeResolver.resolveLocale(request);
		// Create the text message with the language saved in locale
		String mensaje = String.format(messageSource.getMessage("text.login.success", null, locale),
				authentication.getName());

		// Create the flash message showing the username of the user logged in
		flashMap.put("success", mensaje);

		// save the flashMap with the flash message in the manager
		flashMapManager.saveOutputFlashMap(flashMap, request, response);

		if (authentication != null) {
			/*
			 * We implement the log to register in our logger the users who leave
			 * registering
			 */
			logger.info("El usuario '" + authentication.getName() + "' ha iniciado sesión con éxito");
		}

		super.onAuthenticationSuccess(request, response, authentication);
	}

}
