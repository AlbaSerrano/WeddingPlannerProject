package com.plannerofrings.springboot.app.controllers;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plannerofrings.springboot.app.models.entity.Guest;
import com.plannerofrings.springboot.app.models.service.IGuestService;

/*The GuestController responds to user-launched events from
 *  the web that are mapped to the route "/invitados" and and its descendant routes*/
@Controller
//The main route
@RequestMapping("/invitados")
public class GuestController {

	// Inject the service of the entity Guest
	@Autowired
	private IGuestService guestService;

	/*
	 * Method mapped by the route "/invitados/rsvp" to show the page and through the
	 * model we pass to the view the new guest to create
	 */
	@RequestMapping(value = "/rsvp", method = RequestMethod.GET)
	public String loadRsvp(ModelMap mp) {
		// Pass with the model to the view the new guest by the guest key
		mp.addAttribute("guest", new Guest());
		return "forms/rsvp";
	}

	/*
	 * Method mapped by the route "/invitados/rsvp" to create a new guest through
	 * the form of the view mapped to this route with the post type method
	 */
	@RequestMapping(value = "/rsvp", method = RequestMethod.POST)
	public String saveGuest(Guest guest, ModelMap mp) {
		// If the guest is null redirect to the index page
		if (guest == null) {
			return "redirect:/";
		}
		/*If the guest doesn't want to write a suggestion*/
		if (guest.getSuggestion() == null) {
			/*assign empty quotes*/
			guest.setSuggestion("");
		}
		// If not null, save the guest and redirect to the page that contain the list of
		// confirmed guests
		guestService.saveGuest(guest);
		return "redirect:/invitados";
	}

	/*
	 * Method mapped by the route "/invitados/eliminar-invitado/{id}" to delete the
	 * guest with the id that is passed in the route the form of the view mapped to
	 * this route with the post type method
	 * 
	 * @PathVariable indicates that the method parameter (id) should be bound to a
	 * URI template variable.
	 */
	@RequestMapping(value = "/eliminar-invitado/{id}")
	public String deleteGuest(@PathVariable(value = "id") Long id) {
		// If the id exists
		if (id > 0) {
			// Delete this guest
			guestService.deleteGuest(id);
		}
		return "redirect:/invitados";
	}

	/*
	 * Method mapped by the route "/invitados" to show the page and through the
	 * model we pass to the view the list of created guests and the counter of
	 * guests
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listGuests(ModelMap mp) throws ParseException {
		// Get all guests
		List<Guest> guests = guestService.findallGuests();
		// get guests whose age is between 13 and 2 years both included
		List<Guest> childs = guestService.findByBirthDateBetween(dateCalculatorSince(14), dateCalculatorUntil(2));
		// get guests whose age is between 110 and 14 years both included
		List<Guest> adults = guestService.findByBirthDateBetween(dateCalculatorSince(110), dateCalculatorUntil(14));

		if (guests == null) {
			return "redirect:/";
		}

		mp.addAttribute("total", guests.size());
		mp.addAttribute("childs", childs.size());
		mp.addAttribute("adults", adults.size());
		mp.addAttribute("guests", guests);

		return "guests/list_guests";
	}

	/*
	 * Method that subtracts n years from the current date and adds a day to obtain
	 * people who are not n years old
	 */
	public Date dateCalculatorUntil(int year) throws ParseException {
		Calendar c = Calendar.getInstance();
		// Sumar 2 años
		c.add(Calendar.YEAR, -(year));
		// Sumar 1 día
		c.add(Calendar.DAY_OF_YEAR, 1);

		return c.getTime();
	}

	/*
	 * Method that subtracts n years from the current date to obtain people who are
	 * n years old
	 */
	public Date dateCalculatorSince(int year) throws ParseException {
		// Obtain the actual date
		Calendar c = Calendar.getInstance();
		// Add the years of year parameter
		c.add(Calendar.YEAR, -(year));
		// Add one day
		c.add(Calendar.DAY_OF_YEAR, 1);

		return c.getTime();
	}

}
