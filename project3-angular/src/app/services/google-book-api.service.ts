import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IVolume } from '../models/volume.model';

@Injectable({
  providedIn: 'root'
})
export class GoogleBookApiService {

  private BASE_BOOK_URL = "https://www.googleapis.com/books/v1/volumes?q=";
  private ENDPOINTS = {
    results : "startIndex=0&maxResults=20",
    ISBN: "isbn: ", //has to have space after isbn:
    //intitle:{titleName | Or part of titleName
    }

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<any>{
    return this.http.get<any>(
      `${this.BASE_BOOK_URL + this.ENDPOINTS.results}`
    )

  }

  
  getBookByISBN(id: string): Observable<any>{
    return this.http.get<any>(
      `${this.BASE_BOOK_URL + this.ENDPOINTS.ISBN}` + 
      id
    )
  }
}
