package com.plannerofrings.springboot.app.config;

import java.nio.file.Paths;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/* SPRING MVC CONFIGURATION CLASS
 * Defines callback methods to customize the Java-based configuration for Spring MVC*/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	// register our password encoder
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		/*
		 * create and return the component instance and save it in the container
		 * with @Bean
		 */
		return new BCryptPasswordEncoder();
	}

	/*
	 * Method received by a registry to register the View Controller-> which is
	 * going to be a static controller: it just loads the view and it has url but
	 * not have controller logic
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		/*
		 * register the ViewController passing the requestMapping (the url) and we
		 * indicate the view we want to load
		 */
		registry.addViewController("/error_403").setViewName("error_403");
		registry.addViewController("/error_404").setViewName("error_404");
		registry.addViewController("/error_500").setViewName("error_500");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);

		/*
		 * get the schema with the absolute path of the directory uploads with toUri ()
		 * it takes the path and adds the schema file: /
		 */
		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();

		/*
		 * register uploads as a resource directory indicating the path where it is
		 * located
		 */
		registry.addResourceHandler("/uploads/**").addResourceLocations(resourcePath);

	}

	/*
	 * It is in charge of storing the Locale object, with our internationalization,
	 * in the http session every time we save or modify a new locale through from
	 * SessionLocaleResolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		/*
		 * We assign the bean the default locale that receives an instance of the Locale
		 * with 2 parameters: the language code and the country code
		 */
		localeResolver.setDefaultLocale(new Locale("es", "ES"));

		return localeResolver;
	}

	/*
	 * It is in charge of changing the locale every time the new parameter is sent.
	 * language with the new language to change the texts on our page
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {

		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		/*
		 * Every time url is passed the lang parameter the interceptor and will make the
		 * change
		 */
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}

	// Register the localeChangeInterceptor in Spring
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}
