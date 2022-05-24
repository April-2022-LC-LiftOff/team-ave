import { Component, OnInit } from '@angular/core';
import { OccurrenceService } from 'src/app/_services/occurrence.service';
import { Router } from '@angular/router';
import { Occurrence } from 'src/app/occurrence';

@Component({
  selector: 'app-occurrence-log',
  templateUrl: './occurrence-log.component.html',
  styleUrls: ['./occurrence-log.component.css']
})
export class OccurrenceLogComponent implements OnInit {
  occurrence = new Occurrence();
  msg = '';

  constructor(private _service : OccurrenceService, private _route : Router) { }

  ngOnInit(): void {
  }

  createOccurrence() {
    this._service.createOccurrence(this.occurrence).subscribe(
      data=> {
        console.log("Eureka!");
        this._route.navigate(['occurrence'])
      }, 
      error => {
        console.log("something went wrong");
        this.msg=error.error;
      }
    )
  }

}