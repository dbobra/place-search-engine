package com.sofmen.rest.util;

public class CommonUtils {

	public enum Types {
		FOOD("Food"), RESTAURANT("Restaurants"), 
		OTHERS("Others"),CITY("locality"),
		STATE("administrative_area_level_1"), 
		COUNTRY("country"), POSTAL("postal_code");

		private String parameterName;

		private Types(String parameterName) {
			this.setParameterName(parameterName);
		}

		public String getParameterName() {
			return parameterName;
		}

		public void setParameterName(String parameterName) {
			this.parameterName = parameterName;
		}
	}
	
	public enum Days {
		SUNDAY(0),MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6);
		
		private int day;
		
		private Days(int day){
			this.day=day;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}
		
	}
    
	public enum PriceLevel {
		FREE(0),INEXPENSIVE(1),MODERATE(2),EXPENSIVE(3),VERYEXPENSIVE(4);
		
		private int priceLevel;
		
		private PriceLevel(int priceLevel){
			this.priceLevel = priceLevel;
			
		}

		public int getPriceLevel() {
			return priceLevel;
		}

		public void setPriceLevel(int priceLevel) {
			this.priceLevel = priceLevel;
		}
		
		
	}
	
	public enum StatusCode {
		OK("The place successfully detected"),UNKNOWN_ERROR("Server Side error"),ZERO_RESULTS("No result for these place"),OVER_QUERY_LIMIT("Key Expire"),REQUEST_DENIED("Problem on your sensor"),INVALID_REQUEST("Refernce is missing"),NOT_FOUND("NOT found your searching keyword in database");
	
	    private String statusCode;
	    
	    private StatusCode(String statusCode){
	    	this.statusCode=statusCode;
	    }
  	
	}
}


