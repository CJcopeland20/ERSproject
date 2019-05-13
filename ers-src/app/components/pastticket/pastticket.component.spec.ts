import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PastticketComponent } from './pastticket.component';

describe('PastticketComponent', () => {
  let component: PastticketComponent;
  let fixture: ComponentFixture<PastticketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PastticketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PastticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
