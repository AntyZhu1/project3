package com.revature.project3spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.project3spring.entities.BookClub;

import javax.transaction.Transactional;

@Repository
public interface BookClubRepository extends JpaRepository<BookClub, Long> {
	public List<BookClub> findAllBookClubByClubNameContaining(String name);

	@Query(
			value = "select * from book_club where club_Creator_Id = ?1",
			nativeQuery = true)
	public BookClub findBookClubByUserId(long userId);

	@Modifying
	@Transactional
	@Query(
			value = "update book_club set club_current_isbn = ?1 where club_id = ?2",
			nativeQuery = true
	)
	public void updateISBN(long ISBN, long clubId);
}
