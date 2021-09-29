package com.revature.project3spring.entities;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long friendship_id;
    private String username1;
    private String username2;
    //    private Long friend1_id; //user id
//    private Long friend2_id; // user ids
    private String status;
}

//    public  String getUsername1(){
//        return username1;
//    }
//
//    public void setUsername1(String username1){
//        this.username1 = username1;
//    }
//}