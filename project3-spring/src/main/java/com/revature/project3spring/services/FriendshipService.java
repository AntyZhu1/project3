package com.revature.project3spring.services;

import com.revature.project3spring.entities.Friendship;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendshipService {

    Friendship saveFriendship(Friendship friendship);

    List<Friendship> getAllFriendships();

    List<Friendship> listAllUsersFriends(String username1);

    Friendship approveFriendship(long friendship_Id, Friendship friendship);

    Friendship declineFriendship(long friendship_Id, Friendship friendship);
}
