package com.revature.project3spring.services;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.revature.project3spring.entities.CustomUserDetails;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.User;
import com.revature.project3spring.repositories.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender mailSender;

	public void register(User user, String siteURL)
		    throws UnsupportedEncodingException, MessagingException {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);

			String randomCode = RandomString.make(64);
			user.setVerificationCode(randomCode);
			user.setEnabled(false);

			repository.save(user);

			sendVerificationEmail(user, siteURL);

	}

	private void sendVerificationEmail(User user, String siteURL)
		 throws MessagingException, UnsupportedEncodingException {
			String toAddress = user.getEmail();
			String fromAddress = "Your email address";
			String senderName = "Your company name";
			String subject = "Please verify your registration";
			String content = "Dear [[name]],<br>"
					+ "Please click the link below to verify your registration:<br>"
					+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
					+ "Thank you,<br>"
					+ "Your company name.";

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setFrom(fromAddress, senderName);
			helper.setTo(toAddress);
			helper.setSubject(subject);

			//content = content.replace("[[name]]", CustomUserDetails.getFullName());
			String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

			content = content.replace("[[URL]]", verifyURL);

			helper.setText(content, true);

			mailSender.send(message);
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
