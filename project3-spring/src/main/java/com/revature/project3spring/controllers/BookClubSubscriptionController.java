package com.revature.project3spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3spring.entities.subscriptions.BookClubSubscription;
import com.revature.project3spring.services.BookClubSubscriptionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookClubSubscriptionController {
	
	@Autowired
	private BookClubSubscriptionService service;
	
	/*
	 * A subscription object is made up of 4 fields:
	 * subscriptionId: ID of the subscription, used in update and delete mappings
	 * bookClub: a BookClub object
	 * user: a User object
	 * status: a string that can be used to differentiate between different types of subscriptions
	 */
	
	//This POST request creates a new subscription
	@PostMapping("/bookclub/allsubs")
	public BookClubSubscription addSubscription(@RequestBody BookClubSubscription subscription) {
		return service.saveSubsciption(subscription);
	}
	
	//This PUT request updates subscription #id with subscription
	@PutMapping("/bookclub/allsubs/{id}")
	public BookClubSubscription updateSubscription(@PathVariable("id") long id, @RequestBody BookClubSubscription subscription) {
		return service.updateSubscription(subscription, id);
	}
	
	//This DELETE request deletes the subscription with the given id
	@DeleteMapping("/bookclub/allsubs/{id}")
	public void deleteSubscription(@PathVariable("id") long id) {
		service.deleteSubsciption(id);
	}
	
	//This GET request returns the subscription with the given id
	@GetMapping("/bookclub/allsubs/{id}")
	public BookClubSubscription getSubscriptionById(@PathVariable("id") long id) {
		return service.getBookClubSubscriptionBySubscriptionId(id);
	}
	
	//This GET request returns an array containing all subscriptions
	@GetMapping("/bookclub/allsubs")
	public List<BookClubSubscription> getAllBookClubSubscriptions(){
		return service.getAllBookClubSubscription();
	}

	//This GET request returns an array containing all subscriptions to the given bookclub
	@GetMapping("/bookclub/{clubId}/subscribers")
	public List<BookClubSubscription> getBookClubSubscribers(@PathVariable("clubId") long clubId){
		return service.getAllBookClubSubscriptionByBookClubClubId(clubId);
	}
	
	//This GET request returns an array containing all of a given user's subscriptions
	@GetMapping("/user/{userId}/bookclubs")
	public List<BookClubSubscription> getUserSubscriptions(@PathVariable("userId") long userId){
		return service.getAllBookClubSubscriptionByUserUserId(userId);
	}
	
	//This GET request returns an array containing all subscriptions containing the string 'status'
	@GetMapping("/bookclub/allsubs/status={status}")
	public List<BookClubSubscription> getSubscriptionsByStatus(@PathVariable("status") String status){
		return service.getAllBookClubSubscriptionByBookClubSubscriptionStatusContaining(status);
	}
}
