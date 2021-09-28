package com.revature.project3spring.entities.subscriptions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.revature.project3spring.entities.BookClub;
import com.revature.project3spring.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(uniqueConstraints=@UniqueConstraint(columnNames={"userId","clubId"}))
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookClubSubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long subscriptionId;
	
	@ManyToOne
	@JoinColumn(name = "clubId")
	private BookClub bookClub;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private String status;
}
