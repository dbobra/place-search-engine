package com.sofmen.rest.dto;


public class GoogleDTO {

	private Integer placesId;
	private String googlePlaceId;
	private String referenceId;
	private String keyword;
	private Float rating;
	private String types;
	private String mapsUrl;
	private String website;
	private Boolean isOpenNow;
	private Integer priceLevel;
	private String icon; // You have to convert this URL into an Image and then Keep this in a Folder and store the Path in Database for Now; Image name will be the PrimaryKey

	private String address;
	private Double latitude;
	private Double longitude;
	private Double radius;
	private String postcode;
	private String city;
	private String state;
	private String country;
	private String timezone; //America/Los_Angeles; Seperate API
    private String phoneNumber;
    private Integer totalCount;
    
    private String result;
	public Integer getPlacesId() {
		return placesId;
	}
	public void setPlacesId(Integer placesId) {
		this.placesId = placesId;
	}
	public String getGooglePlaceId() {
		return googlePlaceId;
	}
	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getMapsUrl() {
		return mapsUrl;
	}
	public void setMapsUrl(String mapsUrl) {
		this.mapsUrl = mapsUrl;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Boolean getIsOpenNow() {
		return isOpenNow;
	}
	public void setIsOpenNow(Boolean isOpenNow) {
		this.isOpenNow = isOpenNow;
	}
	public Integer getPriceLevel() {
		return priceLevel;
	}
	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getRadius() {
		return radius;
	}
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
}
