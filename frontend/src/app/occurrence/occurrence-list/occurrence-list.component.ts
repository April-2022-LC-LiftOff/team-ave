import { Observable } from 'rxjs';
import { Occurrence } from 'src/app/occurrence';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { OccurrenceService } from 'src/app/service/occurrence.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/_services/token-storage.service';


@Component({
  selector: 'app-occurrence-list',
  templateUrl: './occurrence-list.component.html',
  styleUrls: ['./occurrence-list.component.css']
})
export class OccurrenceListComponent implements OnInit {

  @ViewChild('filterInput')
  filterInputElRef!: ElementRef<HTMLInputElement>;
  
  isSuccessful = false;
  isLoggedin= false;
  errorMessage = '';
  roles: string[] = [];
  currentUser: any;
  occurrences: Occurrence[]=[];
  filteredOccurrences: Occurrence[] = [];
  userId: number;

  constructor( private logService : OccurrenceService, private _route: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    // this.occurrences = [];
    // this.filteredOccurrences=[];
    if(this.tokenStorage.getToken){
      this.isLoggedin=true;
      this.roles = this.tokenStorage.getUser().roles;
    }
    this.currentUser = this.tokenStorage.getUser();
    this.userId = this.tokenStorage.getUser().id;
    this.generateOccurrenceList();
    this.filteredOccurrences = this.occurrences;
    console.log(this.occurrences)
    
 

  }

  generateOccurrenceList(){
    this.logService.getOccurrenceListByUserId(this.userId).subscribe(data =>{
      for(let i=0; i < data.length; i++){
        let tempOccurrence = data[i];
        this.occurrences.push(tempOccurrence);
      }
    }, 
    err => {
      this.errorMessage = err.error.message;
    })
  }

  filter(query: any){
    query = query.toLowerCase().trim();
    let allResults: Occurrence[] = new Array<Occurrence>();
    //split up search query into individual words split by spaces
    let terms: string[] = query.split(' ');
    //remove duplicate search terms
    terms = this.removeDuplicates(terms);
    //gather all relevant results into allresults array
    terms.forEach(term => {
      let results = this.relevantOccurrences(term);
      //append results to the allResults array
      allResults = [...allResults,...results]
    })
    //allResults will include duplucate occurrences
    //so duplicates must be removed
    let uniqueResults = this.removeDuplicates(allResults);
    this.filteredOccurrences = uniqueResults;
    //use the relevancy method
    this.sortByRelevancy(allResults);
  }

  removeDuplicates(arr: Array<any>) : Array<any>{
    let uniqueResults: Set<any> = new Set<any>();
    //loops through input array and add items to set
    arr.forEach(e => uniqueResults.add(e));
    return Array.from(uniqueResults);
  }

  relevantOccurrences(query: string): Array<Occurrence>{
    query = query.toLowerCase().trim();
    let relevantOccurrences = this.occurrences.filter(occurrence => {
      if(occurrence.location && occurrence.location.toLowerCase().includes(query)){
        return true
      }
      if(occurrence.stressors && occurrence.stressors.toLowerCase().includes(query)){
        return true;
      }
      if(occurrence.destressors && occurrence.destressors.toLowerCase().includes(query)){
        return true;
      }
      return false;
    })
    return relevantOccurrences;
  }

  sortByRelevancy(searchResults: Occurrence[]){
    //determine of relevancy based on he number of times it appears in search results
    //format - key: value => occurrenceId:nuumber (occurrence object id: count )
    let noteCountObj: any = {};
    searchResults.forEach(occurrence => {
      //get the occurrence id
      let occurrenceId = occurrence.id;
      if(noteCountObj[occurrenceId]){
        noteCountObj[occurrenceId] += 1;
      }
      else {
        noteCountObj[occurrenceId] = 1;
      }
    })
    this.filteredOccurrences = this.filteredOccurrences.sort((a:Occurrence, b:Occurrence )=>{
      let aId = a.id;
      let bId = b.id;
      let aCount = noteCountObj[aId];
      let bCount = noteCountObj[bId];
      return bCount - aCount;
    })
  }



}
