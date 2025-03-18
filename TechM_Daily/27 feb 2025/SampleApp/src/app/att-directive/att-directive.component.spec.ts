import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttDirectiveComponent } from './att-directive.component';

describe('AttDirectiveComponent', () => {
  let component: AttDirectiveComponent;
  let fixture: ComponentFixture<AttDirectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AttDirectiveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AttDirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
