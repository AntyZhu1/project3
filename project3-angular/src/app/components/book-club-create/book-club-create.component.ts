import { Component, OnInit } from '@angular/core';
import { BookclubService } from 'src/app/services/bookclub.service';

@Component({
  selector: 'app-book-club-create',
  templateUrl: './book-club-create.component.html',
  styleUrls: ['./book-club-create.component.css']
})
export class BookClubCreateComponent implements OnInit {

  user: any;
  bookClub: any;

  constructor(private bookClubService: BookclubService) { }

  ngOnInit(): void {
  }

  onClickSubmit(bookClubName: any, ISBN: any){
    
    this.bookClubService.createBookClub(this.bookClub).subscribe(data =>
      console.log(data)
      )
  }

}
