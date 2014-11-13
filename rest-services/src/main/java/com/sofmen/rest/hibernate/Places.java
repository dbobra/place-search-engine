package com.sofmen.rest.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="places")
public class Places implements Serializable{

	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="place_id")
	private Integer placeId;

	@Id
	@Column(name="google_place_id")
	private String googlePlaceId;

	@Column(name="reference_id")
	private String referenceId;

	@Column(name="keyword")
	private String keyword;

	@Column(name="rating")
	private Float rating;

	@Column(name="maps_url")
	private String mapsUrl;

	@Column(name="website")
	private String website;

	@Column(name="is_open")
	private Boolean isOpenNow;

	@Column(name="pricelevel")
	private Integer priceLevel;

	@Column(name="icon")
	private String icon; // You have to convert this URL into an Image and then Keep this in a Folder and store the Path in Database for Now; Image name will be the PrinmaryKey

	@Column(name="address")
	private String address;

	@Column(name="latitude")
	private Double latitude;

	@Column(name="longitude")
	private Double longitude;

	@Column(name="post_code")
	private String postcode;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="country")
	private String country;

	@Column(name="phone_number")
	private String phoneNumber;

	public Integer getPlacesId() {
		return placeId;
	}

	public void setPlacesId(Integer placesId) {
		this.placeId = placesId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
