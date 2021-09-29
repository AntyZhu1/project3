package com.revature.project3spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.subscriptions.BookClubSubscription;
import com.revature.project3spring.repositories.BookClubSubscriptionRepository;

@Service
public class BookClubSubscriptionServiceImpl implements BookClubSubscriptionService {

	@Autowired
	private BookClubSubscriptionRepository repository;
	
	@Override
	public BookClubSubscription saveSubsciption(BookClubSubscription subscription) {
		return repository.save(subscription);
	}

	@Override
	public BookClubSubscription updateSubscription(BookClubSubscription subscription, long subscriptionId) {
		BookClubSubscription subscriptionDB = subscription;
		subscriptionDB.setSubscriptionId(subscriptionId);
		return repository.save(subscriptionDB);
	}

	@Override
	public void deleteSubsciption(long subscriptionId) {
		repository.deleteById(subscriptionId);
	}

	@Override
	public BookClubSubscription getBookClubSubscriptionBySubscriptionId(long subscriptionId) {
		return repository.getById(subscriptionId);
	}

	@Override
	public List<BookClubSubscription> getAllBookClubSubscription() {
		return repository.findAll();
	}

	@Override
	public List<BookClubSubscription> getAllBookClubSubscriptionByBookClubClubId(long clubId) {
		return repository.findByBookClubClubId(clubId);
	}

	@Override
	public List<BookClubSubscription> getAllBookClubSubscriptionByUserUserId(long userId) {
		return repository.findByUserUserId(userId);
	}

	@Override
	public List<BookClubSubscription> getAllBookClubSubscriptionByBookClubSubscriptionStatusContaining(String status) {
		return repository.findAllBookClubSubscriptionByStatusContaining(status);
	}

}
