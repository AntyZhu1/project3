package com.revature.project3spring.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public BookClub saveBookClub(BookClub bookClub) {
		return repository.save(bookClub);
	}

	@Override
	public BookClub getBookClubById(long clubId) {
		Optional<BookClub> bookClub = repository.findById(clubId);
		return bookClub.get();
	}

	@Override
	public BookClub updateBookClub(BookClub bookClub, long clubId) {
		BookClub bookClubDB = bookClub;
		bookClubDB.setClubId(clubId);
		return repository.save(bookClubDB);
	}

	@Override
	public void deleteBookClub(long clubId) {
		repository.deleteById(clubId);
	}

}
