import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BooksService } from 'src/app/services/books.service';
import { DataService } from 'src/app/services/data.service';
import { ReadlistService } from 'src/app/services/readlist.service';
import { IBook } from 'src/app/models/book.model'

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  public allBooks: any;
  public currentBook: any;
  public isbn: any;

  public bookISBN: any;
  public bookTitle: any;
  public bookAuthor: any;
  public bookSummary: any;
  public bookImage: any;
  public bookPrice: any;
  public book: any;
  public index: any = 0;
  public items: any;
  public title: any;
  public author: any;
  public b: any;

  constructor(private bookService: BooksService, private route: ActivatedRoute, private readlistService: ReadlistService, private dataService: DataService) {
    this.isbn = this.route.snapshot.paramMap.get('ISBN') || '';
    this.title = this.route.snapshot.paramMap.get('title');
    this.author = this.route.snapshot.paramMap.get('author');

    console.log(this.isbn, this.title, this.author);


    // let bookString = JSON.stringify(this.bookService.getBookByISBN(isbn));
    // let bookJSON = JSON.parse(bookString);

    // this.bookISBN = isbn;
    // this.book = bookJSON;
    // this.bookTitle = bookJSON.title;

    // console.log(this.book.title);
    
  }

  ngOnInit(): void {
    if(this.isbn == ''){
      this.dataService.getBooksByTitleAndAuthor(this.title, this.author).subscribe((data) => {
        this.items = data.items;
        console.log(this.items);
      })
  }else{
    this.dataService.getBooksByISBN(this.isbn, this.index).subscribe((data) => {
      this.items = data.items;
      console.log(this.items);
    })
  }
  }

  public addBook(title: any, author: any, image: any, price: any, summary: any, isbn: any) {
    let books = [];
    this.b  = {   title, author, image, price, summary, isbn     }
    console.log(this.b);
    // this.dataService.addBook(this.b);
    this.dataService.addBook(this.b).subscribe(data =>
      console.log(data)
      )
    this.readlistService.addReadlistEntry(this.b);
    alert("Book added to reading list");
  }
}
