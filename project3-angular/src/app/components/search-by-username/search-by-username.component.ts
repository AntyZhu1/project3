import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-by-username',
  templateUrl: './search-by-username.component.html',
  styleUrls: ['./search-by-username.component.css']
})
export class SearchByUsernameComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onClick(username: string){
    this.router.navigate(['users', username]);
  }

}
