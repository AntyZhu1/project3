import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/services/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public result = false;
  public user:User = {
    userId: 0,
    firstName : "",
    lastName: "",
    mobile: "",
    email: "",
    username: "",
    password: "",
    about_me: ""
  };

  constructor(private userService: UserService, private route:Router) { }

  ngOnInit(): void {
  }
  
  public userExists(username: string, password: string): boolean {
    this.userService.userExists(username, password).subscribe(
      (response: boolean) => {
        this.result = response;
      }
    )
    return this.result;
  }

  public currentUser(username: string, password: string): User {
    this.userService.getCurrentUserByUsernameAndPassword(username, password).subscribe(
      (response: User) => {
        this.user = response;
        console.log(response)
      }
    )
    return this.user;
  }

  onClick(username: string, password: string) {
    
    this.result = this.userExists(username, password)

    setTimeout(() => {
      if (this.result == false){
        alert("Invalid Login")
      }
      else {
        alert("Successfull Login")
        this.userService.getCurrentUserByUsernameAndPassword(username, password).subscribe(
          (response: User) => {
            this.user = response;
            this.userService.setCurrentUser(this.user);
          }
        )
        setTimeout(() => {
          this.route.navigate(['/products']);
        }, 500)
      }
    }, 500);

  }
}
