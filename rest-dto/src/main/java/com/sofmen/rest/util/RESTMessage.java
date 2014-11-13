package com.sofmen.rest.util;

public class RESTMessage {
//Create your Messages and Enums Here
	
	public enum statusMessage {
	
		RECORDNOTFOUND("Record not found which is you looking for"),PROBLEMONFETCHING("Problem on fetching your record");
		
		private String statusCode;
		
		private statusMessage(String statusCode){
			this.statusCode=statusCode;
		}

		public String getStatusCode() {
			return statusCode;
		}

		
		
	}
	



}
