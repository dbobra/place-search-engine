package com.sofmen.rest.service;





import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.sofmen.rest.dto.GoogleDTO;
import com.sofmen.rest.util.CommonUtils.Types;

@JsonIgnoreProperties(ignoreUnknown=true)
@Service
public class SearchService {

	private static Logger logger = LoggerFactory.getLogger(SearchService.class);
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    @Value("#{appProperties.nearBySearchUrl}") 
	private  String nearbysearchurl;
	
	@Autowired
	@Value("#{appProperties.key}") 
	private  String key;
	
	@Autowired
	@Value("#{appProperties.textSearchUrl}")
	private String textSearchUrl;
	
	@Autowired
	@Value("#{appProperties.radarSearchUrl}")
	private String radarSearchUrl;
	
	@Autowired
	@Value("#{appProperties.searchDetailUrl}")
	private String searchDetailUrl;
	
	public List<GoogleDTO> displayResult(String keyword,String sensor,double latitude,double longitude,float radius){	
		
		List<GoogleDTO> listPlacesSearch = new ArrayList<GoogleDTO>();
	    logger.info("Gone for searching URL");
	    logger.info(nearbysearchurl+"location="+latitude+","+longitude+"&radius="+radius+"&name="+keyword+"&sensor="+sensor+"&key="+key);
	    String nearBySearchResult  = restTemplate.getForObject(nearbysearchurl+"location="+latitude+","+longitude+"&radius="+radius+"&name="+keyword+"&sensor="+sensor+"&key="+key, String.class);
	    try {
	    	JSONObject jsonObject = new JSONObject(nearBySearchResult);
			 JSONArray result = jsonObject.getJSONArray("results");
			 int totalCount = result.length();
			 for(int i=0;i<totalCount;i++){
				GoogleDTO googleDTO = new GoogleDTO();
				JSONObject places = result.getJSONObject(i);
				logger.info("Places name  "+places.getString("name"));
				/*logger.info("Places id  "+places.getString("id"));
				logger.info("Places reference id   "+places.getString("reference"));
				logger.info("Places types  "+places.getString("types"));*/
			    googleDTO.setKeyword(places.getString("name"));
				googleDTO.setGooglePlaceId(places.getString("id"));
				googleDTO.setReferenceId(places.getString("reference"));
				googleDTO.setIcon(places.getString("icon"));
				//JsonArray Example
				JSONArray js = places.getJSONArray("types");
				String types = "";
				for (int j=0 ; j < js.length(); j++) {
					types = types + js.get(j);
					if(j<js.length()-1){
						types=types.concat(",");
					}
				}
				logger.debug("Types : " + types);
				googleDTO.setTypes( types);
				googleDTO.setAddress(places.getString("vicinity"));
			    listPlacesSearch.add(googleDTO);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    logger.debug("Check for display..");
	    logger.info("Done with searching URL");
	return listPlacesSearch;
	}
 
	
	public String  textSearch(String keyword,String sensor){
		logger.trace("Under the text search service", new SearchService());
	    String textsearchresult =restTemplate.getForObject(textSearchUrl+"query="+keyword+"&sensor="+sensor+"&key="+key,String.class);
	    logger.trace(textsearchresult);
	return textsearchresult;
		
	}
	
	public String radarSearch(String keyword,String sensor,double latitude,double longitude,float radius){
		String radarSearchResult = restTemplate.getForObject(radarSearchUrl+"location="+latitude+","+longitude+"&radius="+radius+"&keyword="+keyword+"&sensor="+sensor+"&key="+key, String.class);
		logger.info(radarSearchResult);
		try {
			JSONObject jsonObject = new JSONObject(radarSearchResult);
			JSONArray result = jsonObject.getJSONArray("results");
			int totalCount = result.length();
			for(int i =0;i<totalCount;i++){
				JSONObject places = result.getJSONObject(i);
				logger.info(places.getString("reference"));
				logger.info(places.getString("id"));
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return radarSearchResult;
	}
	
	public GoogleDTO deatiSearch(String referenceId,String sensor){
		logger.debug("Searching URL formed"+searchDetailUrl+"reference="+referenceId+"&sensor="+sensor+"&key="+key);
		String detailSearchResult = restTemplate.getForObject(searchDetailUrl+"reference="+referenceId+"&sensor="+sensor+"&key="+key, String.class);
		GoogleDTO googleDTO = new GoogleDTO();
		try {
			JSONObject jsonObject = new JSONObject(detailSearchResult);
			JSONObject result = jsonObject.getJSONObject("result");
			googleDTO.setReferenceId(referenceId);
			googleDTO.setPhoneNumber(result.getString("formatted_phone_number"));
			googleDTO.setKeyword(result.getString("name"));
			googleDTO.setIcon(result.getString("icon"));
			googleDTO.setGooglePlaceId(result.getString("id"));
			googleDTO.setRating((Float.parseFloat(result.getString("rating"))));
			googleDTO.setMapsUrl(result.getString("url"));
			googleDTO.setWebsite(result.getString("website"));
			googleDTO.setAddress(result.getString("formatted_address"));
			logger.debug(result.getString("id"));
			logger.debug(result.getString("website"));
			//JSON object for Geometry Location
			JSONObject geometry = result.getJSONObject("geometry");
			JSONObject location = geometry.getJSONObject("location");
			logger.debug("Latitude"+location.getDouble("lat"));
			logger.debug("Longitude"+location.getDouble("lng"));
			googleDTO.setLatitude(location.getDouble("lat"));
			googleDTO.setLongitude(location.getDouble("lng"));
			//JSON Array for Components Address..
			JSONArray componentAddress = result.getJSONArray("address_components");
			for(int i=0 ; i<componentAddress.length();i++){
				JSONObject multiaddress = componentAddress.getJSONObject(i);
				JSONArray types = multiaddress.getJSONArray("types");
				
				for (int j = 0; j < types.length(); j++) {
					logger.debug("" + types.getString(j));
					if (types.getString(j).equalsIgnoreCase(Types.CITY.getParameterName())) {
						logger.debug("city name is " + multiaddress.getString("long_name"));
						googleDTO.setCity(multiaddress.getString("long_name"));
					} else if (types.getString(j).equalsIgnoreCase(Types.COUNTRY.getParameterName())) {
						logger.debug("Country name is " + multiaddress.getString("long_name"));
						googleDTO.setCountry( multiaddress.getString("long_name"));
					} else if (types.getString(j).equalsIgnoreCase(Types.STATE.getParameterName())) {
						logger.debug("State name is " + multiaddress.getString("long_name"));
						googleDTO.setState(multiaddress.getString("long_name"));
					} else if (types.getString(j).equalsIgnoreCase(Types.POSTAL.getParameterName())) {
						logger.debug("Postal code  is "	+ multiaddress.getString("long_name"));
						googleDTO.setPostcode(multiaddress.getString("long_name"));
					}
				}
			 }
			}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return googleDTO;
		
	}
	
	public static void main(String s[]){
		System.out.println("Types " + Types.CITY.getParameterName());
	}
	 
 }

