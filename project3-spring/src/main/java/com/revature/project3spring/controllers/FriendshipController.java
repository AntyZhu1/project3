package com.revature.project3spring.controllers;

import com.revature.project3spring.entities.Friendship;
import com.revature.project3spring.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FriendshipController {


    @Qualifier("friendshipServiceImpl")
    @Autowired
    FriendshipService service;

    @GetMapping("/friendship")
    public List<Friendship> getAllFriendships() {
        return service.getAllFriendships();
    }

    @GetMapping("/usersfriends/{username}")
    public List<Friendship> listAllUsersFriends(@PathVariable("username") String username1) {
        return service.listAllUsersFriends(username1);
    }


    @PostMapping("/friendship/add")

    public Friendship saveFriendship(@RequestBody Friendship friendship) {
        return service.saveFriendship(friendship);
    }

    @PutMapping("/friendship/approve")
    public Friendship approveFriendship(@RequestBody Friendship friendship) {
        return service.approveFriendship(friendship);
    }

    @PutMapping("/friendship/decline")
    public Friendship declineFriendship(@RequestBody Friendship friendship) {
        return service.declineFriendship(friendship);
    }
}

//
//    @Autowired
//    FriendshipService service;
//
//    @GetMapping("/friendship")
//    public List<Friendship> getAllFriendships() {
//        return service.getAllFriendships();
//    }
//
//    @GetMapping("/usersfriends/{username}")
//    public List<Friendship> listAllUsersFriends(@PathVariable("username") String username1) {
//        return service.listAllUsersFriends(username1);
//    }
//
//
//    @PostMapping("/friendship/add")
//
//    public Friendship saveFriendship(@RequestBody Friendship friendship) {
//        return service.saveFriendship(friendship);
//    }
//
//    @PutMapping("/friendship/approve")
//    public Friendship approveFriendship(@RequestBody Friendship friendship) {
//        return service.approveFriendship(friendship);
//    }
//
//    @PutMapping("/friendship/decline")
//    public Friendship declineFriendship(@RequestBody Friendship friendship) {
//        return service.declineFriendship(friendship);
//    }
