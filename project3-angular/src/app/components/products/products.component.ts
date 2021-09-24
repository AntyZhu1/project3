import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IReadlist } from 'src/app/models/readlist.model';
import { BooksService } from 'src/app/services/books.service';
import { ReadlistService } from 'src/app/services/readlist.service';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  public allBooks: any;
  public isbn: any;
  public title: any;
  public author: any;
  public summary: any;
  public image: any;
  public books: any;

  public readList: IReadlist[] = [];
  public bestSellingBooks: any[] = [];
  public selectedBestSellers: any[] = [];
  public viewingBestSellers: any;
  public whichBooks: any;
  public bookFound: any;


  constructor(private bookService: BooksService, private readlistService:
    ReadlistService, private router: Router) { }

  viewBook(book: any) {
    this.router.navigate(['/products', book.isbn])
  }

  ngOnInit(): void {
    // set boolean value to false so all books display when component is initialized
    this.viewingBestSellers = false;

    this.books = this.bookService.getBooks();
    this.bookService.getAllBooks().subscribe((data) => {
      this.allBooks = data
      // allow sorting on all books table at the start
      this.whichBooks = data });
  }

  public addBook(book: any) {
    this.readlistService.addReadlistEntry(book);
  }

  viewAllBooks(){
    // change boolean value to false to display all books table on html
    this.viewingBestSellers = false;

    // allow sorting on all books table again
    this.whichBooks = this.allBooks;
  }

  viewBestSelling(){
    // change boolean value to true to display best selling books table on html
    this.viewingBestSellers = true;

    // get all books currently being read by users
    // set entryNum value to 0 for every book 
    this.readlistService.getReadlist().subscribe(data => {
      this.readList = data;
      this.readList.forEach(readingBook => {
        readingBook.book.entryNum = 0;
      });
      console.log(this.readList);

      // empty out arrays before iterating
      this.bestSellingBooks = [];
      this.selectedBestSellers = [];

      // iterate over readlist entries
      for (let i = 0; i < this.readList.length; i++) {
          
          this.bookFound = false;
          
          if(this.bestSellingBooks.includes(this.readList[i].book === false)){
            this.bestSellingBooks.push(this.readList[i].book);
          } else {
            this.readList[i].book.entryNum += 1;
          }
      
          // iterate over added books
          for (let j = 0; j < this.bestSellingBooks.length; j++) {
          
              // check if readlist entry book is already in array
              // and change boolean value to true if found
              if (this.readList[i].book.isbn == this.bestSellingBooks[j].isbn) {
            
                this.bookFound = true;
          
                // add new property to object and increment 
                // each time book is found in array
                this.bestSellingBooks[j].entryNum += 1;   
              }
          }

          // if book not found (boolean value is false)
          // add book to array
          if (this.bookFound === false) {
              this.bestSellingBooks.push(this.readList[i].book);
          }
      }
      console.log(this.bestSellingBooks);
      
      // only select the book as a best seller if its being read more than once 
      this.bestSellingBooks.forEach(book => {
        if(book.entryNum > 1){
          this.selectedBestSellers.push(book);
        }
      });

      console.log(this.selectedBestSellers);

      // allow sorting on best selling books table
      this.whichBooks = this.selectedBestSellers;
    }, error => {
      console.log(error);
    });
  }
}