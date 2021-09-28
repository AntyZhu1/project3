package com.revature.project3spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.BookClub;

@Service
public interface BookClubService {
	BookClub saveBookClub(BookClub bookClub);
	BookClub getBookClubById(long clubId);
	BookClub updateBookClub(BookClub bookClub, long clubId);
	List<BookClub> getAllBookClub();
	List<BookClub> getAllBookClubByBookClubClubNameContaining(String name);
	void deleteBookClub(long clubId);
}
