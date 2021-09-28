import { Component, OnInit } from '@angular/core';
import { IBookClub } from 'src/app/models/bookclub.model';
import { BookclubService } from 'src/app/services/bookclub.service';
import { User } from 'src/app/user/user';
import { UserService } from 'src/app/user/user.service';

@Component({
  selector: 'app-book-club-create',
  templateUrl: './book-club-create.component.html',
  styleUrls: ['./book-club-create.component.css']
})
export class BookClubCreateComponent implements OnInit {

  user: User = {
    userId: 0,
    firstName: '',
    lastName: '',
    mobile: '',
    email: '',
    username: '',
    password: ''
  };
  bookClub: IBookClub = {
    clubId: 0,
    clubCreatorId: 0,
    clubCurrentIsbn: 0,
    clubName: ''
  };

  constructor(private bookClubService: BookclubService, private userService: UserService) {
    this.user = this.userService.getCurrentUser();
    console.log(this.user);
   }

  ngOnInit(): void {
  }

  onClickSubmit(bookClubName: any, ISBN: any){
    this.bookClub.clubCreatorId = this.user.userId;
    this.bookClub.clubName = bookClubName;
    this.bookClub.clubCurrentIsbn = ISBN;

    this.bookClubService.createBookClub(this.bookClub).subscribe(data =>
      console.log(data)
      )
  }

}
