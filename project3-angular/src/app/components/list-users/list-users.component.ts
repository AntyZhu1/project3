import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  public searchString: string|null;

  constructor(private route: ActivatedRoute) { 
    this.searchString = route.snapshot.paramMap.get('Username');
    console.log(this.searchString);
  }

  ngOnInit(): void {
  }

}
