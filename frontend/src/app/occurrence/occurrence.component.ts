import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OccurrenceService } from '../service/occurrence.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-occurrence',
  templateUrl: './occurrence.component.html',
  styleUrls: ['./occurrence.component.css']
})
export class OccurrenceComponent implements OnInit {
  currentUser: any;
  isSuccessful = false;
  isLoggedIn = false;
  errorMessage= '';
  roles: string[] = [];

  constructor(private _service : OccurrenceService, private _route : Router, private token : TokenStorageService) { }

  ngOnInit(): void {
    if(this.token.getToken()){
      this.isLoggedIn = true;
      this.roles = this.token.getUser().roles;
    }
    if(!this.isLoggedIn){
      this._route.navigateByUrl('/login');
    }
    this.currentUser = this.token.getUser();
  }

  goToUserOccurrences(){
    const userId = this.currentUser.id
    this._route.navigateByUrl('/occurrence/list/' + userId);
  }

  goToCreateOccurrence(){
    const userId = this.currentUser.id
    this._route.navigateByUrl('/occurrence/log');
  }

}
