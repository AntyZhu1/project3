package com.revature.project3spring.controllers;

import com.revature.project3spring.entities.Friendship;
import com.revature.project3spring.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FriendshipController {

    @Autowired
    FriendshipService service;

    @GetMapping("/friendship")
    public List<Friendship> getAllFriendships()	{
        return service.getAllFriendships();
    }

    @PostMapping("/friendship/add")
    public Friendship saveFriendship(@RequestBody Friendship friendship)	{
        return service.saveFriendship(friendship);
    }

    @PutMapping("/friendship/approve/{id}")
    public Friendship approveFriendship(@PathVariable("id") long friendship_id, @RequestBody Friendship friendship)	{
        return service.approveFriendship(friendship_id, friendship);
    }

    @PutMapping("/friendship/decline/{id}")
    public Friendship declineFriendship(@PathVariable("id") long friendship_id, @RequestBody Friendship friendship)	{
        return service.declineFriendship(friendship_id, friendship);
    }
}
