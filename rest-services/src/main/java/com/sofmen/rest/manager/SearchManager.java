package com.sofmen.rest.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sofmen.rest.dao.SearchDAO;
import com.sofmen.rest.dto.GoogleDTO;
import com.sofmen.rest.service.SearchService;

@Component
public class SearchManager {

	@Autowired
	SearchDAO searchDao;

	@Autowired
	SearchService searchService;

	public List<GoogleDTO> displayResult(String keyword, String sensor,	double latitude, double longitude, float radius) {
		List<GoogleDTO> listPlacesSearch = searchService.displayResult(keyword,	sensor, latitude, longitude, radius);
		return listPlacesSearch;
	}

	public String textSearch(String keyword, String sensor) {
		String textSearchResult = searchService.textSearch(keyword, sensor);
		return textSearchResult;
	}

	public String radarSearch(String keyword, String sensor, double latitude,
			double longitude, float radius) {
		String radarSearchResult = searchService.radarSearch(keyword, sensor, latitude, longitude, radius);
		return radarSearchResult;
	}

	public GoogleDTO searchDetail(String referenceId, String sensor) {
		GoogleDTO googleDTO = searchService.deatiSearch(referenceId, sensor);
		return googleDTO;
	}
	
	public void saveDetail(GoogleDTO googleDTO){
		searchDao.saveDetail(googleDTO);
	}
}
