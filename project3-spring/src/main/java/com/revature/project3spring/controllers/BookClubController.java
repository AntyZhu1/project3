package com.revature.project3spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3spring.entities.BookClub;
import com.revature.project3spring.services.BookClubService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookClubController {
	@Autowired
	private BookClubService service;
	
	@GetMapping("/bookclub")
	public List<BookClub> getAllBookClubs(){
		return service.getAllBookClub();
	}
	
	@GetMapping("/bookclub/{name}")
	public List<BookClub> getAllBookClubsContaining(@PathVariable("name") String name){
		return service.getAllBookClubByBookClubClubNameContaining(name);
	}
}
