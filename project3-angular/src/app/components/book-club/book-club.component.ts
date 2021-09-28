import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IBookClub } from 'src/app/models/bookclub.model';
import { BookclubService } from 'src/app/services/bookclub.service';
import { DataService } from 'src/app/services/data.service';
import { User } from 'src/app/user/user';
import { UserService } from 'src/app/user/user.service';

@Component({
  selector: 'app-book-club',
  templateUrl: './book-club.component.html',
  styleUrls: ['./book-club.component.css']
})
export class BookClubComponent implements OnInit {

  books : any;
  book: any;
  clubId: any;
  user : User = {
    userId: 0,
    firstName: '',
    lastName: '',
    mobile: '',
    email: '',
    username: '',
    password: ''
  }
  bookclubs: IBookClub[] = [];
  bookclub : IBookClub = {
    clubId: 0,
    clubCreatorId: 0,
    clubCurrentIsbn: 0,
    clubName: ''
  }

  constructor(private dataService: DataService, private route: ActivatedRoute,
    private bookClubService: BookclubService, private userService: UserService) {
      this.user = this.userService.getCurrentUser();
      console.log(this.user.userId);
   }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.clubId = params.id
    })

    this.bookClubService.getAllUserBookClubByUserId(this.user.userId).subscribe(data =>{
      this.bookclubs = data;
      console.log(this.bookclubs)

      
    })

    //returns a book object by the ISBN
    //Book API returns JSON with an array, so you have to use
    //data.items to get the actual book
    this.bookClubService.getBookClub(34).subscribe(data =>{
      this.bookclub = data;

      this.dataService.getBooksByISBN(this.bookclub.clubCurrentIsbn).subscribe(data =>{
      this.book = data.items;
      console.log(this.book);
    })
    })    

    
    

  }

  

}
