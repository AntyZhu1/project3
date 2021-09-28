import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookclubService {

  private BOOK_CLUB_URL = "http://localhost:9031/bookclub"

  private ENDPOINTS = {
    
  }

  constructor(private http: HttpClient) { }

  createBookClub(data: any): Observable<any>{
    return this.http.post<any>(
      `${this.BOOK_CLUB_URL}`, data
    )
  }
}
