import { Observable } from 'rxjs';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Occurrence } from '../occurrence';

@Injectable({
  providedIn: 'root'
})
export class OccurrenceService {

  constructor(private _http : HttpClient) { }


  public createOccurrence(occurrence : Occurrence): Observable<any>{
    return this._http.post<any>('http://localhost:8080/occurrence/log', occurrence)
  }
}
