package com.revature.project3spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.subscriptions.BookClubSubscription;

@Service
public interface BookClubSubscriptionService {
	BookClubSubscription saveSubsciption(BookClubSubscription subscription);
	BookClubSubscription updateSubscription(BookClubSubscription subscription, long subscriptionId);
	void deleteSubsciption(long subscriptionId);
	BookClubSubscription getBookClubSubscriptionBySubscriptionId(long subscriptionId);
	List<BookClubSubscription> getAllBookClubSubscription();
	List<BookClubSubscription> getAllBookClubSubscriptionByBookClubClubId(long clubId);
	List<BookClubSubscription> getAllBookClubSubscriptionByUserUserId(long userId);
	List<BookClubSubscription> getAllBookClubSubscriptionByBookClubSubscriptionStatusContaining(String status);
}
