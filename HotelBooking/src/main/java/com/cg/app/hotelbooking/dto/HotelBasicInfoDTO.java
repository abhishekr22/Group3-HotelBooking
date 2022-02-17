package com.cg.app.hotelbooking.dto;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.cg.app.hotelbooking.entities.Passengers;
import com.cg.app.hotelbooking.entities.Review;



public class HotelBasicInfoDTO {
	private int hotel_id;
	private String city;
	private String hotel_name;
	private String address;
	private String email;
	private double avg_cost;
	private String phone;
	private String website;
	private int no_of_rooms;
	
	private int count_of_booking;
	private List<Review> reviews;

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAvg_cost() {
		return avg_cost;
	}

	public void setAvg_cost(double avg_cost) {
		this.avg_cost = avg_cost;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getNo_of_rooms() {
		return no_of_rooms;
	}

	public void setNo_of_rooms(int no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}

	public int getCount_of_booking() {
		return count_of_booking;
	}

	public void setCount_of_booking(int count_of_booking) {
		this.count_of_booking = count_of_booking;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	
}
