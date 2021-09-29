package com.revature.project3spring.controllers;

import java.util.List;

import com.revature.project3spring.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3spring.entities.BookClub;
import com.revature.project3spring.services.BookClubService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookClubController {
	@Autowired
	private BookClubService service;
	
	//This GET request returns an array containing all book clubs.
	@GetMapping("/bookclub")
	public List<BookClub> getAllBookClubs(){
		return service.getAllBookClub();
	}
	
	//This GET request returns an array containing all book clubs that contain the variable 'name' in their name.
	/*@GetMapping("/bookclub/name={name}")
	public List<BookClub> getAllBookClubsContaining(@PathVariable("name") String name){
		return service.getAllBookClubByBookClubClubNameContaining(name);
	}*/
	
	//This GET request returns the book club with the given id
	@GetMapping("/bookclub/{id}")
	public BookClub getBookClubById(@PathVariable("id") long id) {
		return service.getBookClubById(id);
	}
	
	//This PUT request replaces book club #id with the given book club object
	@PutMapping("/bookclub/{id}")
	public BookClub updateBookClub(@PathVariable("id") long id, @RequestBody BookClub bookClub) {
		return service.updateBookClub(bookClub, id);
	}
	
	//This POST request creates a new book club
	@PostMapping("/bookclub")
	public BookClub addBookClub(@RequestBody BookClub bookClub) {

		return service.saveBookClub(bookClub);
	}
	
	//This DELETE request deletes the book club with the given id
	@DeleteMapping("/bookclub/{id}")
	public void deleteBookClub(@PathVariable("id") long id) {
		service.deleteBookClub(id);
	}

	@GetMapping("/bookclub/user/{id}")
	public BookClub getBookClubByUserId(@PathVariable("id") long userId){
		return service.getBookClubByUserId(userId);
	}

	@PutMapping("/bookclub/{clubId}/{ISBN}")
	public void updateISBN(@PathVariable long clubId,
						   @PathVariable String ISBN){
		System.out.println(clubId);
		System.out.println(ISBN);
		long ISBNnum = Long.parseLong(ISBN);
		service.updateISBN(ISBNnum, clubId);
	}
}
