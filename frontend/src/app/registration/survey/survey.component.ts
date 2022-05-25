import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {Component, ElementRef, ViewChild} from '@angular/core';
import {FormControl} from '@angular/forms';
import {MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';
import {MatChipInputEvent} from '@angular/material/chips';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { TagsService } from 'src/app/_services/tags.service';
import { TokenStorageService } from 'src/app/_services/token-storage.service';
  
@Component({
  selector: 'survey',
  templateUrl: 'survey.component.html',
  styleUrls: ['survey.component.css'],
})

export class SurveyComponent {
  errorMessage = '';
  currentUser: any;
  form: any = {
    stressors: null,
    helpers: null,
    donts: null,
  };

    separatorKeysCodes: number[] = [ENTER, COMMA];

    stressorCtrl = new FormControl();
    filteredStressors: Observable<string[]>;
    stressors: string[] = [];
    allStressors: string[] = [];

    helperCtrl = new FormControl();
    filteredHelpers: Observable<string[]>;
    helpers: string[] = [];
    allHelpers: string[] = [];

    dontCtrl = new FormControl();
    filteredDonts: Observable<string[]>;
    donts: string[] = [];
    allDonts: string[] = [];
  
    @ViewChild('stressorInput') stressorInput!: ElementRef<HTMLInputElement>;
    @ViewChild('helperInput') helperInput!: ElementRef<HTMLInputElement>;
    @ViewChild('dontInput') dontInput!: ElementRef<HTMLInputElement>;
  
    constructor(private tagsService: TagsService, private token: TokenStorageService) {

      this.filteredStressors = this.stressorCtrl.valueChanges.pipe(
        startWith(null),
        map((stressor: string | null) => (stressor ? this._filterStressor(stressor) : this.allStressors.slice())),
      );
      this.filteredHelpers = this.helperCtrl.valueChanges.pipe(
        startWith(null),
        map((helper: string | null) => (helper ? this._filterHelper(helper) : this.allHelpers.slice())),
      );
      this.filteredDonts = this.dontCtrl.valueChanges.pipe(
        startWith(null),
        map((dont: string | null) => (dont ? this._filterDont(dont) : this.allDonts.slice())),
      );
    }

    ngOnInit(): void {
      this.currentUser = this.token.getUser();
      this.allDonts = this.currentUser.donts;
      this.allHelpers = this.currentUser.helpers;
      this.allStressors = this.currentUser.stressors;
    }
  
    addStressor(event: MatChipInputEvent): void {
      const value = (event.value || '').trim();
  
      // Add our stressor
      if (value) {
        this.stressors.push(value);
      }
  
      // Clear the input value
      event.chipInput!.clear();
  
      this.stressorCtrl.setValue(null);
    }

    addHelper(event: MatChipInputEvent): void {
      const value = (event.value || '').trim();
  
      // Add our helper
      if (value) {
        this.helpers.push(value);
      }
  
      // Clear the input value
      event.chipInput!.clear();
  
      this.helperCtrl.setValue(null);
    }

    addDont(event: MatChipInputEvent): void {
      const value = (event.value || '').trim();
  
      // Add our dont
      if (value) {
        this.donts.push(value);
      }
  
      // Clear the input value
      event.chipInput!.clear();
  
      this.dontCtrl.setValue(null);
    }
  
    removeStressor(stressor: string): void {
      const index = this.stressors.indexOf(stressor);
  
      if (index >= 0) {
        this.stressors.splice(index, 1);
      }
    }

    removeHelper(helper: string): void {
      const index = this.helpers.indexOf(helper);
  
      if (index >= 0) {
        this.helpers.splice(index, 1);
      }
    }

    removeDont(dont: string): void {
      const index = this.donts.indexOf(dont);
  
      if (index >= 0) {
        this.donts.splice(index, 1);
      }
    }
  
    selectedStressor(event: MatAutocompleteSelectedEvent): void {
      this.stressors.push(event.option.viewValue);
      this.stressorInput.nativeElement.value = '';
      this.stressorCtrl.setValue(null);
    }

    selectedHelper(event: MatAutocompleteSelectedEvent): void {
      this.helpers.push(event.option.viewValue);
      this.helperInput.nativeElement.value = '';
      this.helperCtrl.setValue(null);
    }
    
    selectedDont(event: MatAutocompleteSelectedEvent): void {
      this.donts.push(event.option.viewValue);
      this.dontInput.nativeElement.value = '';
      this.dontCtrl.setValue(null);
    }

    private _filterStressor(value: string): string[] {
      const filterValue = value.toLowerCase();
  
      return this.allStressors.filter(stressor => stressor.toLowerCase().includes(filterValue));
    }

    private _filterHelper(value: string): string[] {
      const filterValue = value.toLowerCase();
  
      return this.allHelpers.filter(helper => helper.toLowerCase().includes(filterValue));
    }

    private _filterDont(value: string): string[] {
      const filterValue = value.toLowerCase();
  
      return this.allDonts.filter(dont => dont.toLowerCase().includes(filterValue));
    }

    onSubmit(): void {
      const userId = this.currentUser.id;
      const username = this.currentUser.username;
      const { stressors, helpers, donts } = this.form;
      this.tagsService.addTags(stressors, helpers, donts, userId, username).subscribe(
        data => {
          console.log(data);
          this.reloadPage();
        },
        err => {
          this.errorMessage = err.error.message;
        }
      );
    }
    reloadPage(): void {
      window.location.reload();
    }
  }
