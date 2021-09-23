package com.revature.project3spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3spring.entities.Friendship;
import com.revature.project3spring.services.FriendshipService;

@RestController
public class FriendshipController {

    @Autowired
    FriendshipService service;

    @GetMapping("/friendship")
    public List<Friendship> getAllFriendships()	{
        return service.getAllFriendships();
    }

    @PostMapping("/friendship/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public Friendship saveFriendship(@RequestBody Friendship friendship)	{
        return service.saveFriendship(friendship);
    }

    @GetMapping("/friendship/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Friendship getFriendshipById(@PathVariable("id") long friendshipId)	{
        return service.getFriendshipById(friendshipId);
    }

    @PutMapping("/friendship/approve/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Friendship approveFriendship(@PathVariable("id") long friendshipId, @RequestBody Friendship friendship)	{
        return service.approveFriendship(friendshipId, friendship);
    }

    @PutMapping("/friendship/decline/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Friendship declineFriendship(@PathVariable("id") long friendshipId, @RequestBody Friendship friendship)	{
        return service.declineFriendship(friendshipId, friendship);
    }

    @GetMapping("/friendship/{friend1_id}/{friend2_id}")
    public Boolean FriendshipExists(@PathVariable("id") long friend1_id, @PathVariable("id") long friend2_id) {
        return service.friendshipExists(friend1_id, friend2_id);
    }

    @GetMapping("/friendshipapproved/friendship/{friend1_id}/{friend2_id}")
    public Friendship findFriendshipByUsersId(@PathVariable("id") long friend1_id, @PathVariable("id") long friend2_id) {
        return service.getFriendship(friend1_id, friend2_id);
    }
}
