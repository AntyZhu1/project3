package com.revature.project3spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.BookClub;

@Service
public interface BookClubService {
	List<BookClub> getAllBookClub();
	List<BookClub> getAllBookClubByBookClubClubNameContaining(String name);
}
