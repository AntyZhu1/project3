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
    public List<Friendship> listAllUsersFriends(String username1) {
        return null;
    }

    @Override
    public Friendship declineFriendship(long friendship_id, Friendship friendship) {
        Friendship friendshipDB = repository.getById(friendship_id);
        friendshipDB.setStatus("declined");

        return repository.save(friendshipDB);
    }

	@Override
    public Friendship approveFriendship(long friendship_id, Friendship friendship) {
        Friendship friendshipDB = repository.getById(friendship_id);
        friendshipDB.setStatus("approved");

        return repository.save(friendshipDB);
	}

}
