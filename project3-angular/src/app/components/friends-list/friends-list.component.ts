import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Friendship } from 'src/app/friendship/friendship';
import { FriendshipService } from 'src/app/friendship/friendship.service'
import { User } from 'src/app/user/user';
import { UserService } from 'src/app/user/user.service';

@Component({
  selector: 'app-friends-list',
  templateUrl: './friends-list.component.html',
  styleUrls: ['./friends-list.component.css']
})
export class FriendsListComponent implements OnInit {

  public searchString: any;

  public friends: Friendship[] = [] 
  
  constructor(private router: Router, private friendshipService: FriendshipService, private userService:UserService, private route:ActivatedRoute) { 
    this.searchString = route.snapshot.paramMap.get('Username');
    console.log(this.searchString);
    this.friendshipService.listAllUsersFriends(this.searchString).subscribe((data: Friendship[]) => {this.friends = data; console.log(data)});
  }

  ngOnInit(): void {
  }

  approveFriendRequest(friend:any){
  
    this.friendshipService.approveFriendship(friend).subscribe((data) => {console.log("friend added")})
    window.location.reload();
  }

  declineFriendRequest(friend:any){
    this.friendshipService.declineFriendship(friend).subscribe((data) => {console.log("friend declined")})
    window.location.reload();
  }
}
