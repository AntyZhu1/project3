package com.revature.project3spring.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.revature.project3spring.repositories.UserRepository;
import com.revature.project3spring.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3spring.entities.User;
import com.revature.project3spring.services.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

//@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RestController
public class UserController {

	@Qualifier("userServiceImpl")
	@Autowired
	private UserServiceImpl service;

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/user")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@PostMapping("/process_register")
	public String processRegister(User user, HttpServletRequest request)
			throws UnsupportedEncodingException, MessagingException {
		service.register(user, getSiteURL(request));
		return "register_success";
	}

	private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}

	@PostMapping("/user/add")
	@CrossOrigin(origins = "http://localhost:4200")
	public User saveUser(@RequestBody User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);

		return service.saveUser(user);
	}

	@GetMapping("/user/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User getUserById(@PathVariable("id") long userId) {
		return service.getUserById(userId);
	}

	@PutMapping("/user/update/{id}")
	public User updateUser(@PathVariable("id") long userId, @RequestBody User user) {
		return service.updateUser(userId, user);
	}

	@GetMapping("/user/{username}/{password}")
	public Boolean userExists(@PathVariable("username") String username, @PathVariable("password") String password) {
		return service.userExists(username, password);
	}

	@GetMapping("/user/user/{username}/{password}")
	public User getUserByUsernameAndPassword(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return service.getUserByUsernameAndPassword(username, password);
	}

	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
		if (service.verify(code)) {
			return "verify_success";
		} else {
			return "verify_fail";
		}
	}
}
