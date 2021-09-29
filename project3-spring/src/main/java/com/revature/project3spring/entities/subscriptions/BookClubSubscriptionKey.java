package com.revature.project3spring.entities.subscriptions;

import java.io.Serializable;

import com.revature.project3spring.entities.BookClub;
import com.revature.project3spring.entities.User;

public class BookClubSubscriptionKey implements Serializable {
	private BookClub bookClub;
	private User user;
}
