package com.cg.app.hotelbooking.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.hotelbooking.service.IFlightService;
import com.cg.app.hotelbooking.service.IHotelService;
import com.cg.app.hotelbooking.service.IReviewService;
import com.cg.app.hotelbooking.dto.ReviewBasicInfoDTO;
import com.cg.app.hotelbooking.dto.ReviewSavePostDTO;
import com.cg.app.hotelbooking.entities.*;

@RequestMapping("/review")
@RestController
public class reviewWebRestController {
	
	@Autowired IReviewService service;
	@Autowired IFlightService flightservice;
	@Autowired
	IHotelService hotelservice;
	@GetMapping("/")
	public String welcomepage() {
		return "<h1> Welcome To Review's Module</h1>"; 
	}
	@GetMapping("/allreviews")
	public List<Review> getallreviews(HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getallreviews();
		}
		return null;
	}
	@PutMapping("/savereview")
	public ResponseEntity<ReviewBasicInfoDTO> savereview(@Valid @RequestBody ReviewSavePostDTO review,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		ReviewBasicInfoDTO dto=service.saveReview(review);
		return new ResponseEntity<ReviewBasicInfoDTO>(dto,HttpStatus.OK);
		}
		return null;
	}
	@GetMapping("/fname/{flight_name}")
	public List<Review> getreviewflightsbyname(@PathVariable String flight_name,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getreviewbyflightname(flight_name);}
		return null;
	}
	
	@GetMapping("/hname/{city}/{rating1}/{rating2}")
	public List<Hotel> gethotelreviewbycityrange(@PathVariable String city,@PathVariable int rating1,@PathVariable int rating2,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.gethotelrangeratings(city, rating1, rating2);
		}return null;
	}
	
	@GetMapping("/deletereview/{review_id}")
	public boolean deletebyreviewid(@PathVariable int review_id,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.deletebyreviewid(review_id);
		}
		return false;
	}
	
	@GetMapping("/get/{review_id}")
	public Review getbyreviewid(@PathVariable int review_id,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getreviewbyreviewid(review_id);
		}
		return null;
	}
	
	@GetMapping("/getuser/{user_id}")
	public List<Review> getreviewbyuserid(@PathVariable int user_id,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getreviewbyuserid(user_id);
		}return null;
	}
	
	
	
	@GetMapping("/cityreview/{city}")
	public List<Hotel> sorthotelbycity(@PathVariable String city,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.sorthotelbycity(city);}
		return null;
	}
	
	@GetMapping("/hotel/{hotel_name}")
	public List<Review> getreviewbyhotelname(@PathVariable String hotel_name,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getreviewbyhotelname(hotel_name);
		}
		return null;
	}
	
	@GetMapping("/hadd/{hotel_id}/{review_id}")
	public String addReview(@PathVariable int hotel_id,@PathVariable int review_id,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.addReview(hotel_id,review_id);
		}
		return null;
	}
	@PutMapping("/fadd/{flight_id}/{review_id}")
	public String addFlightReview(@PathVariable int flight_id,@PathVariable int review_id,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return flightservice.addReview(flight_id,review_id);
		}return null;
	}
	@GetMapping("/avg/{flight_id}")
	public String getAvgRatingOfFlight(@PathVariable int flight_id,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.avgRating(flight_id);
		}return "not found";
	}
	@GetMapping("/havg/{hotel_id}")
	public String getAvgRatingOfHotel(@PathVariable int hotel_id,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return hotelservice.avgRating(hotel_id);
		}return "not found";
	}

	
}
