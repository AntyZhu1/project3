package com.revature.project3spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.project3spring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsernameAndPassword(String username, String password);
    
	//Searches for all users whos username contains the given string
    List<User> findAllUserByUsernameContaining(String username);
}
