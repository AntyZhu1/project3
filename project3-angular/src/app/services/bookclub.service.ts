import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookclubService {

  bookClub: any;

  private BOOK_CLUB_URL = "http://localhost:9031/bookclub"

  private ENDPOINTS = {
    
  }

  constructor(private http: HttpClient) { }

  createBookClub(data: any): Observable<any>{
    this.bookClub = data;
    return this.http.post<any>(
      `${this.BOOK_CLUB_URL}`, data
    )
  }

  public getAllUserBookClubByUserId(id: number) : Observable<any>{
    return this.http.get<any>(
      "http://localhost:9031/users/" + id +"/bookclubs"
    )
  }

  getBookClub(id: number): Observable<any>{
    return  this.http.get<any>(
      `${this.BOOK_CLUB_URL + "/" + id}`
    )
  }
}
