import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterApprovalComponent } from './register-approval.component';

describe('RegisterApprovalComponent', () => {
  let component: RegisterApprovalComponent;
  let fixture: ComponentFixture<RegisterApprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterApprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
