package com.revature.project3spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.BookClub;
import com.revature.project3spring.repositories.BookClubRepository;

@Service
public class BookClubServiceImpl implements BookClubService {
	@Autowired
	private BookClubRepository repository;
	
	@Override
	public List<BookClub> getAllBookClub() {
		return repository.findAll();
	}

	@Override
	public List<BookClub> getAllBookClubByBookClubClubNameContaining(String name) {
		return repository.findAllBookClubByClubNameContaining(name);
	}

}
