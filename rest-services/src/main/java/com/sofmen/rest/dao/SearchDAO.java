package com.sofmen.rest.dao;



import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofmen.rest.dto.GoogleDTO;
import com.sofmen.rest.hibernate.Places;

@Service
@Transactional
public class SearchDAO {

	
	@Autowired
	SessionFactory sessionFactory;
 
	
	private static Logger logger = LoggerFactory.getLogger(SearchDAO.class);
	
	public void saveDetail(GoogleDTO googleDTO){
		
		//Get all the values from GoogleDTO and set on Places Class..
		Places places = new Places();
		places.setAddress(googleDTO.getAddress());
		places.setCity(googleDTO.getCity());
		places.setCountry(googleDTO.getCountry());
		places.setGooglePlaceId(googleDTO.getGooglePlaceId());
		places.setIcon(googleDTO.getIcon());
		places.setKeyword(googleDTO.getKeyword());
		places.setLatitude(googleDTO.getLatitude());
		places.setLongitude(googleDTO.getLongitude());
		places.setMapsUrl(googleDTO.getMapsUrl());
		places.setPhoneNumber(googleDTO.getPhoneNumber());
		places.setPostcode(googleDTO.getPostcode());
		places.setRating(googleDTO.getRating());
		places.setState(googleDTO.getState());
		places.setWebsite(googleDTO.getWebsite());
		
		sessionFactory.getCurrentSession().save(places);
		logger.debug("Save data is ", places);
		
		
	}
	
	
}
