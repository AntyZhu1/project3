import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IBookClub } from '../models/bookclub.model';

@Injectable({
  providedIn: 'root'
})
export class BookclubService {

  bookClub: any;

  private BOOK_CLUB_URL = "http://localhost:9031/bookclub"

  private ENDPOINTS = {
    
  }

  constructor(private http: HttpClient) { }

  public createBookClub(data: any): Observable<any>{
    this.bookClub = data;
    return this.http.post<any>(
      `${this.BOOK_CLUB_URL}`, data
    )
  }

  public getBookClubByUserId(id: number) : Observable<IBookClub>{
    return this.http.get<IBookClub>(
      `${this.BOOK_CLUB_URL + "/user/" + id}`
    )
  }

  public getAllBookClubByUserId(id: number) : Observable<IBookClub>{
    return this.http.get<IBookClub>(
      "http://localhost:9031/user/" + id +"/bookclubs"
    )
  }

  public getBookClub(id: number): Observable<any>{
    return  this.http.get<any>(
      `${this.BOOK_CLUB_URL + "/" + id}`
    )
  }

  public updateISBN(clubId: number, ISBN: number): Observable<any>{
    return this.http.put<any>(
      `${this.BOOK_CLUB_URL + "/" + clubId + "/" + ISBN}`, {clubId, ISBN}
    )
  }
}
