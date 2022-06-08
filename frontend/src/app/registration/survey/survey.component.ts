import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { Component } from '@angular/core';
import { MatChipInputEvent } from '@angular/material/chips';
import {
  FormGroup,
  Validators,
  FormBuilder,
  FormArray,
} from '@angular/forms';
import { TagsService } from 'src/app/_services/tags.service';
import { TokenStorageService } from 'src/app/_services/token-storage.service';
import { MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';

// still uses fruits because I tried changing it and it broke for some reason
// fruits = stressors, 2 = helpers, 3 = donts
// need to figure out how to add autocomplete again (not really necessary here but would work well with the occurrence log)

@Component({
  selector: 'survey',
  templateUrl: 'survey.component.html',
  styleUrls: ['survey.component.css'],
})
export class SurveyComponent {
  errorMessage = '';
  currentUser: any;
  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  form: FormGroup;

  constructor(private fb: FormBuilder, private tagsService: TagsService, private token: TokenStorageService) {
    this.currentUser = this.token.getUser();
    this.form = this.fb.group({
      fruits: this.fb.array([], Validators.required),
      fruits2: this.fb.array([], Validators.required),
      fruits3: this.fb.array([], Validators.required),
    });
  }

  get fruitControls(): FormArray {
    return this.form.controls['fruits'] as FormArray;
  }

  get fruitControls2(): FormArray {
    return this.form.controls['fruits2'] as FormArray;
  }

  get fruitControls3(): FormArray {
    return this.form.controls['fruits3'] as FormArray;
  }

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our stressor
    if ((value || '').trim()) {
      this.fruitControls.push(this.fb.control(value));
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }
  }

  remove(fruit: string): void {
    const index = this.fruitControls.value.indexOf(fruit);
    if (index >= 0) {
      this.fruitControls.removeAt(index);
    }
  }

  add2(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our helper
    if ((value || '').trim()) {
      this.fruitControls2.push(this.fb.control(value));
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }
  }

  remove2(fruit: string): void {
    const index = this.fruitControls2.value.indexOf(fruit);
    if (index >= 0) {
      this.fruitControls2.removeAt(index);
    }
  }

  add3(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our dont
    if ((value || '').trim()) {
      this.fruitControls3.push(this.fb.control(value));
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }
  }

  remove3(fruit: string): void {
    const index = this.fruitControls3.value.indexOf(fruit);
    if (index >= 0) {
      this.fruitControls3.removeAt(index);
    }
  }

  onSubmit(): void {
    const userId = this.currentUser.id;
    const username = this.currentUser.username;

    let fstressors = this.fruitControls.value;
    let fhelpers = this.fruitControls2.value;
    let fdonts = this.fruitControls3.value;
    
    this.tagsService.addTags(fstressors, fhelpers, fdonts, userId, username).subscribe(
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