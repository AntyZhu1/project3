import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IVolume } from 'src/app/models/volume.model';
import { GoogleBookApiService } from 'src/app/services/google-book-api.service';

@Component({
  selector: 'app-book-club',
  templateUrl: './book-club.component.html',
  styleUrls: ['./book-club.component.css']
})
export class BookClubComponent implements OnInit {

  books : any;
  book: any;
  clubId: any;

  constructor(private googleBookService: GoogleBookApiService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    //Grabs an ID from the url
    this.route.params.subscribe(params => {
      this.clubId = params.id
    })
    
    this.googleBookService.getAllBooks().subscribe(data =>{
      this.books = data.items;
      console.log(this.books)
    })

    //returns a book object by the ISBN
    //Book API returns JSON with an array, so you have to use
    //data.items to get the actual book
    this.googleBookService.getBookByISBN("9780471783831").subscribe(data =>{
      this.book = data.items;
      console.log(this.book);
    })

  }

}
