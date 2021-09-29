package com.revature.project3spring.services;

import com.revature.project3spring.entities.Friendship;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendshipService {

    Friendship saveFriendship(Friendship friendship);
    List<Friendship> getAllFriendships();
    List<Friendship> getFriendshipsByUsername(String username1);
    Friendship approveFriendship(long friendship_id, Friendship friendship);
    Friendship declineFriendship(long friendship_id, Friendship friendship);
}
