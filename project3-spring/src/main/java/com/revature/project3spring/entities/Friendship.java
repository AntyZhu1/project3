package com.revature.project3spring.entities;

import lombok.*;

import javax.persistence.*;

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
    private String status;

}
