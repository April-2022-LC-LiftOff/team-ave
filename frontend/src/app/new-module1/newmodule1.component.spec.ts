import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Newmodule1Component } from './newmodule1.component';

describe('Newmodule1Component', () => {
  let component: Newmodule1Component;
  let fixture: ComponentFixture<Newmodule1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Newmodule1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Newmodule1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
