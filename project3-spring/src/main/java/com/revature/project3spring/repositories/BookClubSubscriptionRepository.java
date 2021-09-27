package com.revature.project3spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.project3spring.entities.subscriptions.BookClubSubscription;

@Repository
public interface BookClubSubscriptionRepository extends JpaRepository <BookClubSubscription, Long> {
	public List<BookClubSubscription> findByBookClubClubId(long clubId);
	public List<BookClubSubscription> findByUserUserId(long userId);
	public List<BookClubSubscription> findAllBookClubSubscriptionByStatusContaining(String status);
}
