import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  constructor(private dataService: DataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    //Grabs an ID from the url
    this.route.params.subscribe(params => {
      this.clubId = params.id
    })
<<<<<<< HEAD
=======
    
    this.googleBookService.getAllBooks().subscribe(data =>{
      this.books = data.items;
      console.log(this.books)
    })
>>>>>>> 9c625d933e1c3496d198e880c7b1c8f86d65e4de

    //returns a book object by the ISBN
    //Book API returns JSON with an array, so you have to use
    //data.items to get the actual book
    this.dataService.getBooksByISBN(9780471783831).subscribe(data =>{
      this.book = data.items;
      console.log(this.book);
    })

  }

}
