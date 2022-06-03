import { Observable } from 'rxjs';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Occurrence } from '../occurrence';
import { A } from '@angular/cdk/keycodes';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class OccurrenceService {

  AUTH_API = 'http://localhost:8080/api/auth/occurrence/log';
  AUTH_API2 = 'http://localhost:8080/api/auth/occurrence/list';
  constructor(private _http : HttpClient) { }

   createOccurrence(location: string, stressors: string, destressors: string, description: string ,userId: number): Observable<any>{
    return this._http.post(this.AUTH_API, {
      location, 
      stressors, 
      destressors,
      description, 
      userId
    }, httpOptions);
  }

   getOccurrenceListByUserId(userId: number): Observable<any>{
    console.log(userId);
    return this._http.get(`${this.AUTH_API2}/${userId}`, httpOptions);
  }

   getOccurrenceById(id: number){
    console.log(id);
    return this._http.get(`${this.AUTH_API}/${id}`, httpOptions);
  }

  updateOccurrence( occurrenceId: number ,location: string, stressors, destressors: string, userId: number): Observable<any>{
    return this._http.patch(`${this.AUTH_API}/${occurrenceId}`,{
    occurrenceId,
    location,
    stressors,
    destressors,
    userId,
    },httpOptions);
  }


}
