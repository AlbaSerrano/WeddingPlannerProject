package com.plannerofrings.springboot.app.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.plannerofrings.springboot.app.models.entity.Brides;
import com.plannerofrings.springboot.app.models.entity.History;
import com.plannerofrings.springboot.app.models.entity.Wedding;
import com.plannerofrings.springboot.app.models.service.FamilyService;
import com.plannerofrings.springboot.app.models.service.IBridesService;
import com.plannerofrings.springboot.app.models.service.IHistoryService;
import com.plannerofrings.springboot.app.models.service.IUploadFileService;
import com.plannerofrings.springboot.app.models.service.IWeddingService;
import com.plannerofrings.springboot.app.models.service.MemoryService;

/*The WeddingController responds to user-launched events from
 *  the web that are mapped to the route "/" and and its descendant routes*/
@Controller
//The main route
@RequestMapping(value = "/")
public class WeddingController {

	/*
	 * object used to log messages during the execution of a program to the console
	 */
	Logger log = LoggerFactory.getLogger(WeddingController.class);

	/* inject the following objects */

	/* Service for Brides entity */
	@Autowired
	private IBridesService bridesService;

	/* Service for Wedding entity */
	@Autowired
	private IWeddingService weddingService;

	/* Service for History entity */
	@Autowired
	private IHistoryService historyService;

	/* Service for uploads files to the project */
	@Autowired
	private IUploadFileService uploadFileService;

	/* Service for Memory entity */
	@Autowired
	private MemoryService memoryService;

	/* Service for Family entity */
	@Autowired
	private FamilyService familyService;

	/*
	 * Get Method mapped by the route "/" to show the index page and through the
	 * model we pass to the view the list of family and the brides with id=1
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap mp) {

		/* Save the object with id = 1 */
		Brides brides = bridesService.findOne((long) 1);
		/* If doesn't exist the object redirect to the index page */
		if (brides == null) {
			return "/create_wedding";
		}
		/*
		 * Add to the model the object brides and the list of family to pass to the view
		 */
		mp.addAttribute("brides", brides);
		mp.addAttribute("families", familyService.findAll());
		return "index";
	}

	/*
	 * Get Method mapped by the route "/crear-boda" to load the view with the form
	 * to create a wedding , only the user with ADMIN role has the authority to
	 * access
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/crear-boda", method = RequestMethod.GET)
	public String nuevo(ModelMap mp) {
		/* Pass to the view the new object */
		mp.put("brides", new Brides());
		// Return the view that contain the form to create a wedding
		return "forms/form_brides_new";
	}

	/*
	 * Post Method mapped by the route "/crear-boda" to create a new Brides object ,
	 * only the user with ADMIN role has the authority to access
	 * 
	 * @RequestParam is a Spring annotation used to bind a web request parameter to
	 * a method parameter. In our case, obtain the web request parameter from the
	 * view to save the files selected and then create the Brides object
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/crear-boda", method = RequestMethod.POST)
	public String crear(Brides brides, Wedding wedding, History history,
			@RequestParam("brideFile") MultipartFile bridePhoto, @RequestParam("groomFile") MultipartFile groomPhoto,
			@RequestParam("ceremonyFile") MultipartFile ceremonyPhoto,
			@RequestParam("partyFile1") MultipartFile partyPhoto1,
			@RequestParam("partyFile2") MultipartFile partyPhoto2,
			@RequestParam("howMeetFile") MultipartFile howMeetPhoto,
			@RequestParam("timeTogetherFile") MultipartFile timeTogetherPhoto,
			@RequestParam("weddingRequestFile") MultipartFile weddingRequestPhoto, ModelMap mp) {

		/* if the user has uploaded a valid file */
		if (!bridePhoto.isEmpty() && !groomPhoto.isEmpty() && !ceremonyPhoto.isEmpty() && !partyPhoto1.isEmpty()
				&& !partyPhoto2.isEmpty()) {

			try {
				/*
				 * Assign the unique file name, that return the method copy, of the file to the
				 * bridePhoto, groomPhoto, ceremonyPhoto, partyPhotos, howMeetPhoto,
				 * timeTogetherPhoto and weddingRequest fields of the entity Brides
				 */
				brides.setBridePhoto(uploadFileService.copy(bridePhoto));
				brides.setGroomPhoto(uploadFileService.copy(groomPhoto));
				wedding.setCeremonyPhoto(uploadFileService.copy(ceremonyPhoto));
				wedding.setPartyPhoto1(uploadFileService.copy(partyPhoto1));
				wedding.setPartyPhoto2(uploadFileService.copy(partyPhoto2));
				history.setHowMeetPhoto(uploadFileService.copy(howMeetPhoto));
				history.setTimeTogetherPhoto(uploadFileService.copy(timeTogetherPhoto));
				history.setWeddingRequestPhoto(uploadFileService.copy(weddingRequestPhoto));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Set the new wedding to the brides
		brides.setWedding(wedding);
		// Set the new history to the brides
		brides.setHistory(history);
		// Save the new brides object
		bridesService.save(brides);
//Pass to the view the created brides
		mp.put("brides", brides);

		return "redirect:/";
	}

	/*
	 * Get Method mapped by the route "/editar-boda" to load the view with the form
	 * to edit the wedding , only the user with ADMIN role has the authority to
	 * access
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/editar-boda", method = RequestMethod.GET)
	public String editar(ModelMap mp) {
		/* Pass to the view the brides object with the id=1 */
		mp.put("brides", bridesService.findOne((long) 1));
		// Return the view that contain the form to edit the wedding
		return "forms/form_brides_edit";
	}

	/*
	 * Post Method mapped by the route "/editar-boda" to edit a Brides object , only
	 * the user with ADMIN role has the authority to access
	 * 
	 * @RequestParam is a Spring annotation used to bind a web request parameter to
	 * a method parameter. In our case, obtain the web request parameter from the
	 * view to save the files selected and then edit the Brides object
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/editar-boda", method = RequestMethod.POST)
	public String actualizar(Brides brides, BindingResult bindingResult,
			@RequestParam("brideFile") MultipartFile bridePhoto, @RequestParam("groomFile") MultipartFile groomPhoto,
			@RequestParam("ceremonyFile") MultipartFile ceremonyPhoto,
			@RequestParam("partyFile1") MultipartFile partyPhoto1,
			@RequestParam("partyFile2") MultipartFile partyPhoto2,
			@RequestParam("howMeetFile") MultipartFile howMeetPhoto,
			@RequestParam("timeTogetherFile") MultipartFile timeTogetherPhoto,
			@RequestParam("weddingRequestFile") MultipartFile weddingRequestPhoto, ModelMap mp) {

		// Save the brides with the id equals to the id of the brides object parameter
		Brides bridesUpdate = bridesService.findOne(brides.getId());

		// Save the wedding with the id equals to the id of the brides object parameter
		Wedding weddingUpdate = weddingService.findOne(brides.getId());

		// Save the history with the id equals to the id of the brides object parameter
		History historyUpdate = historyService.findOne(brides.getId());

		/* if the user has uploaded a valid file */
		if (!bridePhoto.isEmpty() || !groomPhoto.isEmpty()) {

			try {
				/*
				 * Assign the unique file name, that return the method copy, of the file to the
				 * bridePhoto, groomPhoto, ceremonyPhoto, partyPhotos, howMeetPhoto,
				 * timeTogetherPhoto and weddingRequest fields field of the entity Brides
				 */
				bridesUpdate.setBridePhoto(uploadFileService.copy(bridePhoto));
				bridesUpdate.setGroomPhoto(uploadFileService.copy(groomPhoto));
				weddingUpdate.setCeremonyPhoto(uploadFileService.copy(ceremonyPhoto));
				weddingUpdate.setPartyPhoto1(uploadFileService.copy(partyPhoto1));
				weddingUpdate.setPartyPhoto2(uploadFileService.copy(partyPhoto2));
				historyUpdate.setHowMeetPhoto(uploadFileService.copy(howMeetPhoto));
				historyUpdate.setTimeTogetherPhoto(uploadFileService.copy(timeTogetherPhoto));
				historyUpdate.setWeddingRequestPhoto(uploadFileService.copy(weddingRequestPhoto));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/*
		 * Set to the updated brides the properties that obtain by the brides object
		 * parameter that the user edits through the form edit view
		 */
		bridesUpdate.setNameBride(brides.getNameBride());
		bridesUpdate.setNameGroom(brides.getNameGroom());
		bridesUpdate.setAboutHer(brides.getAboutHer());
		bridesUpdate.setAboutHim(brides.getAboutHim());
		bridesUpdate.setWeddingDate(brides.getWeddingDate());

		/*
		 * Set to the updated wedding the properties that obtain by the brides object
		 * parameter that the user edits through the form edit view
		 */
		weddingUpdate.setCeremonyPlace(brides.getWedding().getCeremonyPlace());
		weddingUpdate.setCeremonyHour(brides.getWedding().getCeremonyHour());
		weddingUpdate.setCeremonyDescription(brides.getWedding().getCeremonyDescription());
		weddingUpdate.setPartyPlace(brides.getWedding().getPartyPlace());
		weddingUpdate.setPartyHour(brides.getWedding().getPartyHour());
		weddingUpdate.setPartyDescription(brides.getWedding().getPartyDescription());

		// Assign the updated wedding to the updated brides object
		bridesUpdate.setWedding(weddingUpdate);

		/*
		 * Set to the updated history the properties that obtain by the brides object
		 * parameter that the user edits through the form edit view
		 */
		historyUpdate.setHowMeet(brides.getHistory().getHowMeet());
		historyUpdate.setTimeTogether(brides.getHistory().getTimeTogether());
		historyUpdate.setWeddingRequest(brides.getHistory().getWeddingRequest());

		// Assign the updated history to the updated brides object
		bridesUpdate.setHistory(historyUpdate);

		// Save the updated object
		bridesService.save(bridesUpdate);

		// Pass to the view the updated brides object
		mp.put("brides", bridesUpdate);

		return "redirect:/";
	}

	/*
	 * Method mapped by the uri "/boda" that sent the brides object with id=1 to the
	 * location view and return the view to show the location info
	 */
	@RequestMapping(value = "/boda")
	public String showLocationWedding(ModelMap mp) {
		// Save the brides object with id=1
		Brides brides = bridesService.findOne((long) 1);
		// If not exists the object return the view to create a wedding
		if (brides == null) {
			return "/create_wedding";
		}
		// Pass to the view the brides object
		mp.addAttribute("brides", brides);
		return "location/location";
	}

	/*
	 * Method mapped by the uri "/galeria" that sent the list of memories to the
	 * memories view and return the view to show the memories of the couple
	 */
	@RequestMapping(value = "/galeria")
	public String showMemories(ModelMap mp) {
		// Pass to the view the list of memories
		mp.addAttribute("memories", memoryService.findAll());
		return "gallery/memories";
	}

	/*
	 * Method mapped by the uri "/menu" that return the view to show the qr code
	 * with the wedding menu
	 */
	@RequestMapping(value = "/menu")
	public String showMenu() {
		return "menu/wedding-menu";
	}
}
