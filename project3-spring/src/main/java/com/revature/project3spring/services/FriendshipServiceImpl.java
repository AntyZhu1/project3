package com.revature.project3spring.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3spring.entities.Friendship;
import com.revature.project3spring.repositories.FriendshipRepository;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    @Autowired
    private FriendshipRepository repository;

    @Override
    public Friendship saveFriendship(Friendship friendship) {
        return repository.save(friendship);
    }

    @Override
    public List<Friendship> getAllFriendships() {
        return repository.findAll();
    }

    @Override
    public Friendship getFriendshipById(long friendship_Id) {
        return null;
    }

    @Override
    public Friendship approveFriendship(long friendship_id, Friendship friendship) {
        Friendship friendshipDB = repository.getById(friendship_id);
        friendshipDB.setStatus(friendship.getStatus());

        return repository.save(friendshipDB);
    }

    @Override
    public Friendship declineFriendship(long friendship_id, Friendship friendship) {
        Friendship friendshipDB = repository.getById(friendship_id);
        friendshipDB.setStatus(friendship.getStatus());

        return repository.save(friendshipDB);
    }


    @Override
    public Boolean friendshipExists(long friend1_id, long friend2_id) {
        Friendship friendshipDB = repository.findFriendshipByUsersId(friend1_id, friend2_id);
        if (friendshipDB != null) {
            return true;
        } else
            return false;
    }

    @Override
    public Friendship findFriendshipByUsersId(long friend1_id, long friend2_id) {
        return null;
    }

    @Override
    public List<Friendship> getAllUsersFriendships(long userId) {
        return null;
    }

    @Override
    public Friendship getFriendship(long friend1_id, long friend2_id) {
        Friendship friendship = repository.findByFriendship(friend1_id, friend2_id);
        return friendship;
    }

}