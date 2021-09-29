import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/user/user.service';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  public searchString: any;

  public users: any;

  constructor(private route: ActivatedRoute, private userService: UserService) { 
    this.searchString = route.snapshot.paramMap.get('Username');
    console.log(this.searchString);
    this.users = this.userService.getUsersByUsername(this.searchString).subscribe((data) => {this.users = data});
  }

  ngOnInit(): void {
  
  }
  
  sendFriendRequest(username : string)  {
    
  }

}