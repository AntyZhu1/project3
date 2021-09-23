package com.revature.project3spring.services;

import java.util.List;

import com.revature.project3spring.entities.Friendship;
import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.Friendship;

@Service
public interface FriendshipService {

    Friendship saveFriendship(Friendship friendship);
    List<Friendship> getAllFriendships();
	Friendship approveFriendship(long friendship_id, Friendship friendship);
	Friendship declineFriendship(long friendship_id, Friendship friendship);
}
