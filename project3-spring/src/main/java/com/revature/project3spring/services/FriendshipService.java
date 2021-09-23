package com.revature.project3spring.services;

import java.util.List;

import com.revature.project3spring.entities.Friendship;
import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.Friendship;

@Service
public interface FriendshipService {

    Friendship saveFriendship(Friendship friendship);

    List<Friendship> getAllFriendships();

    Friendship getFriendshipById(long friendship_Id);

    // here approve or decline friendship "status" = "approved" or "status" = "declined"
    Friendship approveFriendship(long userId, Friendship friendship);
    Friendship declineFriendship(long userId, Friendship friendship);

    // this need to be set up as friend1_id, perhaps, always being the
    // current logged in user and friend2_id the id of the user being viewed... profile
    Boolean friendshipExists(long friend1_id, long friend2_id);
    Friendship findFriendshipByUsersId(long friend1_id, long friend2_id);

    // this userId below needs to exist and match friend1_id or friend2_id
    List<Friendship> getAllUsersFriendships(long userId);

    Friendship getFriendship(long friend1_id, long friend2_id);
}