import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookclubService } from 'src/app/services/bookclub.service';

@Component({
  selector: 'app-book-club-update',
  templateUrl: './book-club-update.component.html',
  styleUrls: ['./book-club-update.component.css']
})
export class BookClubUpdateComponent implements OnInit {

  clubId: any;
  ISBNnum: number = 0;

  constructor(private bookClubService: BookclubService, private route: ActivatedRoute,
    private router: Router) {
   }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.clubId = params.clubId
      console.log(this.clubId)
    })
  }

  onClickSubmit(ISBN: any){
    console.log(typeof(this.ISBNnum));
    
    this.bookClubService.updateISBN(this.clubId,ISBN).subscribe(data =>{
      console.log(data);
      
    })

    // this.router.navigate(['/bookclub']);
  }
}
