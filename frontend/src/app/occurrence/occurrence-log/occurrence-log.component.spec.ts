import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OccurrenceLogComponent } from './occurrence-log.component';

describe('OccurrenceLogComponent', () => {
  let component: OccurrenceLogComponent;
  let fixture: ComponentFixture<OccurrenceLogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OccurrenceLogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OccurrenceLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
