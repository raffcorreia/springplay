import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { XssExperienceComponent } from './xss-experience.component';

describe('XssExperienceComponent', () => {
  let component: XssExperienceComponent;
  let fixture: ComponentFixture<XssExperienceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ XssExperienceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(XssExperienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
