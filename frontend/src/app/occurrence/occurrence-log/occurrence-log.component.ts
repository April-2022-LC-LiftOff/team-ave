import { TokenStorageService } from './../../_services/token-storage.service';
import { Component, OnInit } from '@angular/core';
import { OccurrenceService } from 'src/app/service/occurrence.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Occurrence } from 'src/app/occurrence';

@Component({
  selector: 'app-occurrence-log',
  templateUrl: './occurrence-log.component.html',
  styleUrls: ['./occurrence-log.component.css']
})
export class OccurrenceLogComponent implements OnInit {
  currentUser: any;
  form: any = {
    location: null,
    stressors: null,
    destressors: null,
    description: null
  };

  isNew!: boolean;
  isSuccessful = false;
  isLoggedIn = false;
  errorMessage= '';
  roles: string[] = [];
  occurrence?: any;
  occurrenceId!: number;
  

  constructor(private _service : OccurrenceService, private _route : Router, 
    private token : TokenStorageService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    if(this.token.getToken()){
      this.isLoggedIn = true;
      this.roles = this.token.getUser().roles;
    }
    if(!this.isLoggedIn){
      this._route.navigateByUrl('/login');
    }
    this.route.params.subscribe((params:Params)=>{
      this.occurrence  = new Occurrence();
      if(params['id']){
        this.occurrence = this._service.getOccurrenceById(params['id']);
        this.occurrenceId= params['id'];
        this.isNew = false;
      } else {
        this.isNew= true;
      }
    })
  }

  createOccurrence(){
    const userId = this.token.getUser().id;
    const { location, stressors, destressors, description} = this.form;
    if(this.isNew){
    this._service.createOccurrence( location, stressors, destressors, description, userId).subscribe(
      data=> {
        this.isSuccessful = true;
      console.log("eureka!")
      },
      err => {
        this.isSuccessful = false;
        this.errorMessage = err.error.message;
      })
    } else {
      this._service.updateOccurrence(this.occurrenceId, location, stressors, destressors, userId).subscribe(
        data=> {
          this.isSuccessful = true;
          console.log("updated");
        }
      )
    } 
    this._route.navigateByUrl('/profile');
  }

}
