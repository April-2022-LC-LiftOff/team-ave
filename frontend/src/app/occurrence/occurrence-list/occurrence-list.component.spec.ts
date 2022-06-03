import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OccurrenceListComponent } from './occurrence-list.component';

describe('OccurrenceListComponent', () => {
  let component: OccurrenceListComponent;
  let fixture: ComponentFixture<OccurrenceListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OccurrenceListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OccurrenceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
