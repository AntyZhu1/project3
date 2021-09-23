package com.revature.project3spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.project3spring.entities.Friendship;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long>{

    Friendship findFriendshipByUsersId(long friend1_id, long friend2_id);

    Friendship findByFriendship(long friend1_id, long friend2_id);
}
