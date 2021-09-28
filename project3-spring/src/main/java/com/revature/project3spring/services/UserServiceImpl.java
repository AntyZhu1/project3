package com.revature.project3spring.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.User;
import com.revature.project3spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender mailSender;

	public void register(User user, String siteURL) {

	}

	private void sendVerificationEmail(User user, String siteURL) {

	}
	@Override
	public User saveUser(User user) {

		return repository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		Optional<User> user = repository.findById(userId);
		if (!user.isPresent()) {

		}
		return user.get();
	}

	@Override
	public User updateUser(long userId, User user) {
		User userDB = repository.getById(userId);
		userDB.setFirstName(user.getFirstName());
		userDB.setLastName(user.getLastName());
		userDB.setEmail(user.getEmail());
		userDB.setMobile(user.getMobile());
		userDB.setUsername(user.getUsername());
		userDB.setPassword(user.getPassword());
		return repository.save(userDB);
	}

	@Override
	public Boolean userExists(String username, String password) {
		User userDB = repository.findByUsernameAndPassword(username, password);
		if (userDB != null) {
			return true;
		} else
			return false;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		User user = repository.findByUsernameAndPassword(username, password);
		return user;
	}

	@Override
	public boolean verify(String verification) {
		User user = repository.findByVerificationCode(verification);
		if (user == null || user.isEnabled()) {
			return false;
		} else {
			user.setVerificationCode(null);
			user.setEnabled(true);
			repository.save(user);
		}
		return true;
	}
}
