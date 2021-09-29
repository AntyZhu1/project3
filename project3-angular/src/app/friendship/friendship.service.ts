import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Friendship } from './friendship';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FriendshipService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

savefriendship(username1:any, username2:any): Observable<Friendship> {
    return this.http.get<Friendship>(`${this.apiServerUrl}/user`)
  }

}