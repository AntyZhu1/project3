import { Component, OnInit } from '@angular/core';
import { BooksService } from 'src/app/services/books.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-books-display',
  templateUrl: './books-display.component.html',
  styleUrls: ['./books-display.component.css']
})
export class BooksDisplayComponent implements OnInit {
  pageViews: any;
  bookObj: any;
  constructor(private bookService: BooksService) {
    
    
    
   }
  ngOnInit(): void {
  //  this.pageViews = this.getPageViews();
  //  if(this.pageViews < 2 || this.bookObj.length < 1) {
     this.bookObj = this.getBooks();
  //  }
    // console.log(`Books: ${JSON.stringify(this.bookObj)}`)
  }
getPageViews() {
  let pw: any; 
  pw = localStorage.getItem("page-views") || 0;
  if(pw > 0) {
    pw = ((pw * 1) + 1)
    console.log(`PAGE VIEWS: ${pw}`);
    localStorage.setItem("page-views", pw);
    return pw;
  }
  localStorage.setItem("page-views", "1"); 
  return 1;
}
getBooks() {
  console.log(this.bookService.getBooks());
  return this.bookService.getBooks();
}
sortByTitle() {
  this.bookObj = this.bookObj.sort(function(a: any,b: any) {
     return a.title > b.title
   })
} 
sortByAuthor() {
  this.bookObj = this.bookObj.sort(function(a: any,b: any) {
    return a.author > b.author
  })
}
sortByPrice() {
  this.bookObj = this.bookObj.sort(function(a: any,b: any) {
    return a.price.value > b.price.value
  })
}

sortByPriceR() {
  this.bookObj = this.bookObj.sort(function(a: any,b: any) {
    return a.price.value < b.price.value
  })
}

}
