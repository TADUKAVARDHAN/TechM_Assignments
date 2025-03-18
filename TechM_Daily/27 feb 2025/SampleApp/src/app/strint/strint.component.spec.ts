import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StrintComponent } from './strint.component';

describe('StrintComponent', () => {
  let component: StrintComponent;
  let fixture: ComponentFixture<StrintComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StrintComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StrintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
