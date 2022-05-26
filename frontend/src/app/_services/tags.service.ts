
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/tags';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class TagsService {
  constructor(private http: HttpClient) { }
  
  addTags(stressors: string[], helpers: string[], donts: string[], userId: number, username: string): Observable<any> {
    return this.http.post(AUTH_API + '/add', {
      stressors,
      helpers,
      donts,
      userId,
      username
    }, httpOptions);
  }
}

