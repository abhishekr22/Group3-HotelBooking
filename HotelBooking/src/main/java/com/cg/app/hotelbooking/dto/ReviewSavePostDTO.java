package com.cg.app.hotelbooking.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Range;

public class ReviewSavePostDTO {
	
	@Id
	
	private int review_id;
	private String feedback;
	@Range(min =1, max=5)
	private int rating;
	private int service_id;
	private int user_id;
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

	public ReviewSavePostDTO(int review_id, String feedback, @Range(min = 1, max = 5) int rating, int service_id,
			int user_id) {
		super();
		this.review_id = review_id;
		this.feedback = feedback;
		this.rating = rating;
		this.service_id = service_id;
		this.user_id = user_id;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
