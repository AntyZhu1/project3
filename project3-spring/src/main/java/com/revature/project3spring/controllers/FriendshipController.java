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
    
    @PutMapping("/friendship/approve/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Friendship approveFriendship(@PathVariable("id") long friendship_id, @RequestBody Friendship friendship)	{
        return service.approveFriendship(friendship_id, friendship);
    }

    @PutMapping("/friendship/decline/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Friendship declineFriendship(@PathVariable("id") long friendship_id, @RequestBody Friendship friendship)	{
        return service.declineFriendship(friendship_id, friendship);
    }
    
    
}
