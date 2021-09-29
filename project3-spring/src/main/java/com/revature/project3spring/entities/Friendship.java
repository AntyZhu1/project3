package com.revature.project3spring.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long friendship_id;
    private Long friend1_id;
    private Long friend2_id;
    private String status;
    private Date date;
    
// couldn't get posting without adding the below
    
	public Friendship() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Friendship(Long friendship_id, Long friend1_id, Long friend2_id, String status, Date date) {
		super();
		this.friendship_id = friendship_id;
		this.friend1_id = friend1_id;
		this.friend2_id = friend2_id;
		this.status = status;
		this.date = date;
	}
	public Long getFriendship_id() {
		return friendship_id;
	}
	public void setFriendship_id(Long friendship_id) {
		this.friendship_id = friendship_id;
	}
	public Long getFriend1_id() {
		return friend1_id;
	}
	public void setFriend1_id(Long friend1_id) {
		this.friend1_id = friend1_id;
	}
	public Long getFriend2_id() {
		return friend2_id;
	}
	public void setFriend2_id(Long friend2_id) {
		this.friend2_id = friend2_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Friendship [friendship_id=" + friendship_id + ", friend1_id=" + friend1_id + ", friend2_id="
				+ friend2_id + ", status=" + status + ", date=" + date + "]";
	}
	

}
