import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserProfileService } from 'src/app/services/user-profile.service'
import { FriendshipService } from 'src/app/friendship/friendship.service'

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  public searchString: any;

  public users: any;

  constructor(private route: ActivatedRoute, private userService: UserProfileService, private friendshipService: FriendshipService) { 
    this.searchString = route.snapshot.paramMap.get('Username');
    console.log(this.searchString);
    this.users = this.userService.getUsersByUsername(this.searchString).subscribe((data) => {this.users = data});
  }

  ngOnInit(): void {
  
  }
  
  sendFriendRequest(username : string)  {
    this.friendshipService.savefriendship(this.userService.getCurrentUser().username, username);
  }

}
