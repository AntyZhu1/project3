package com.revature.project3spring.entities.subscriptions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.revature.project3spring.entities.BookClub;
import com.revature.project3spring.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(BookClubSubscriptionKey.class)
public class BookClubSubscription {
	@Id
	private long subscriptionId;
	
	@ManyToOne
	@JoinColumn(name = "clubId")
	private BookClub bookClub;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private String status;
}
