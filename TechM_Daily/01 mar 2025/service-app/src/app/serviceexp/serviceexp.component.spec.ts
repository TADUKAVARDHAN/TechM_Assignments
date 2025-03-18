import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceexpComponent } from './serviceexp.component';

describe('ServiceexpComponent', () => {
  let component: ServiceexpComponent;
  let fixture: ComponentFixture<ServiceexpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceexpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServiceexpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
