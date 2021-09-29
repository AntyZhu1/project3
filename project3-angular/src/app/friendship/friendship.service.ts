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

public savefriendship(friendship: Friendship): Observable<Friendship> {
    return this.http.post<Friendship>(`${this.apiServerUrl}/friendship/add`, friendship)
  }

}