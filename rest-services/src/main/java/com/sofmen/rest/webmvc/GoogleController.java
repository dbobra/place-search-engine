package com.sofmen.rest.webmvc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sofmen.rest.dto.GoogleDTO;
import com.sofmen.rest.manager.SearchManager;



@Controller
@RequestMapping("/search")
public class GoogleController {
	/**Your Controllers or REST URIs here + Models*/
	
	private static Logger logger = LoggerFactory.getLogger(GoogleController.class);
	
	@Autowired
	SearchManager searchManager;
	
	
	@RequestMapping(value="/nearbysearch" ,method=RequestMethod.POST)
	public String nearSearch(@RequestParam String keyword,ModelMap model){
		GoogleDTO googleDTO = new GoogleDTO();
		logger.trace("GoogleDTO", googleDTO);
		googleDTO.setKeyword(keyword);
		model.addAttribute("googleDTO",googleDTO);
		logger.trace("Google DTO mapped and redirect to nearbysearch.jsp");
		return "nearbysearch";
	}
	
	@RequestMapping(value="/textsearch")
	public String textSearch(@RequestParam String keyword,@RequestParam String sensor,ModelMap model){
		String searchResult = searchManager.textSearch(keyword, sensor);
		logger.trace(searchResult);
		model.addAttribute("",null);
		return "display";
	}
	
	@RequestMapping(value="/radarsearch")
	public String radarSearch(@RequestParam String keyword,ModelMap model){
		GoogleDTO googleDTO = new GoogleDTO();
		googleDTO.setKeyword(keyword);
		model.addAttribute("googleDTO",googleDTO);
		return "radarsearch";
		
	}
	
	@RequestMapping(value="/nearbyresultdisplay" ,method=RequestMethod.GET)
	public String nearByResultDisplay(@RequestParam String keyword,@RequestParam String sensor, @RequestParam double latitude, @RequestParam double longitude,@RequestParam float radius,ModelMap model){
		logger.info("Compile the near by resultDisplay method");
		List<GoogleDTO> listPlacesSearch =	searchManager.displayResult(keyword, sensor, latitude, longitude, radius);
	    model.put("listPlacesSearch",listPlacesSearch);
		return "display";
	}
	
	@RequestMapping(value="/radarresultdisplay",method=RequestMethod.GET)
	public String radarResultDisplay(@RequestParam String keyword,@RequestParam String sensor, @RequestParam double latitude, @RequestParam double longitude,@RequestParam float radius,ModelMap model){
		logger.info("Compile the radar search resultDisplay method");
		String result =searchManager.radarSearch(keyword, sensor, latitude, longitude, radius);
		GoogleDTO googleDTO = new GoogleDTO();
		googleDTO.setResult(result);
		model.addAttribute("googleDTO",googleDTO	);
		return "display";
	}
	
	@RequestMapping(value="/detailsearch")
	public String detailSearch(@RequestParam String referenceId,@RequestParam String sensor ,ModelMap model){
		GoogleDTO googleDTO = new GoogleDTO();
		googleDTO=searchManager.searchDetail(referenceId, sensor);
		model.addAttribute("googleDTO", googleDTO);
		return "detailsearch";
	}
	
	/**
	 * To Save the Details via Google Places
	 * Required Parameters : ReferenceId, Name, Latitude, Longitude etc.
	 * 
	 * 
	 * @param referenceId
	 * @param sensor
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveDetail(@RequestParam String referenceId,@RequestParam String sensor){
		logger.debug(referenceId);
		logger.debug(sensor);
		GoogleDTO googleDTO = searchManager.searchDetail(referenceId, sensor);
		searchManager.saveDetail(googleDTO);
		return "save";
	}

}
