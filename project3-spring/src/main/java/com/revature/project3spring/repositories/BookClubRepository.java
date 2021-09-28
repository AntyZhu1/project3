package com.revature.project3spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.project3spring.entities.BookClub;

@Repository
public interface BookClubRepository extends JpaRepository<BookClub, Long> {
	public List<BookClub> findAllBookClubByClubNameContaining(String name);
}
