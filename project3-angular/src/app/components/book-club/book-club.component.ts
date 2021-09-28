import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IBookClub } from 'src/app/models/bookclub.model';
import { BookclubService } from 'src/app/services/bookclub.service';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-book-club',
  templateUrl: './book-club.component.html',
  styleUrls: ['./book-club.component.css']
})
export class BookClubComponent implements OnInit {

  books : any;
  book: any;
  clubId: any;
  bookclub : IBookClub = {
    clubId: 0,
    clubCreatorId: 0,
    clubCurrentIsbn: 0,
    clubName: ''
  }

  constructor(private dataService: DataService, private route: ActivatedRoute,
    private bookClubService: BookclubService) {
      
   }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.clubId = params.id
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
