import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/user/user.service';
import { FriendshipService } from 'src/app/friendship/friendship.service';
import { Friendship } from 'src/app/friendship/friendship';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  public searchString: any;

  public users: any;

  public friendship: Friendship = {
    friendship_Id: 0,
    username1: "",
    username2: "",
    status: "Pending"
  };

  constructor(private route: ActivatedRoute, private userService: UserService, private friendShip: FriendshipService) { 
    this.searchString = route.snapshot.paramMap.get('Username');
    console.log(this.searchString);
    this.users = this.userService.getUsersByUsername(this.searchString).subscribe((data) => {this.users = data});
  }

  ngOnInit(): void {
  
  }
  
  sendFriendRequest(username : string)  {
    this.friendship.username1 = this.userService.getCurrentUser().username;
    this.friendship.username2 = username;
    this.friendShip.savefriendship(this.friendship).subscribe((data) => {this.friendship = data; console.log("friend added")});
  
    
  }

}
