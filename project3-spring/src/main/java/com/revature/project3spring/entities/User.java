package com.revature.project3spring.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private String mobile;
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(unique = true)
	private String username;
	@Column(name = "")
	private String password;

	//for email verification
	@Column(name="verification_code", length = 64)
	private String verificationCode;

	// if enabled is true, user should be able to login
	// Initially false
	private boolean enabled;

}
