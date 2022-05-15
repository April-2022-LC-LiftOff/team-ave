import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostRegistrationComponent } from './post-registration.component';

describe('PostRegistrationComponent', () => {
  let component: PostRegistrationComponent;
  let fixture: ComponentFixture<PostRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
