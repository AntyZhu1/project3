package com.revature.project3spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookClub {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long clubId;
	private long clubCreatorId;
	private long clubCurrentIsbn;
	private String clubName;
}
