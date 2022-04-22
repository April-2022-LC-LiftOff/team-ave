import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewOccurrenceComponent } from './review-occurrence.component';

describe('ReviewOccurrenceComponent', () => {
  let component: ReviewOccurrenceComponent;
  let fixture: ComponentFixture<ReviewOccurrenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewOccurrenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewOccurrenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
