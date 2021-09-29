package com.revature.project3spring.services;

import com.revature.project3spring.entities.Friendship;
import com.revature.project3spring.repositories.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public  List<Friendship> listAllUsersFriends(String username1) {

        List<Friendship> userFriendships = repository.findAll();
        userFriendships.removeIf(userFriendship -> (!userFriendship.getUsername2().equals(username1)));
        return userFriendships;
    }

    @Override
    public Friendship approveFriendship( Friendship friendship) {

        friendship.setStatus("Approved");

        return repository.save(friendship);
    }

    @Override
    public Friendship declineFriendship(Friendship friendship) {

        friendship.setStatus("Declined");

        return repository.save(friendship);
    }

}