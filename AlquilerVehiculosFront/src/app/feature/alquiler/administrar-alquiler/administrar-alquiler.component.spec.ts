import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrarAlquilerComponent } from './administrar-alquiler.component';

describe('AdministrarAlquilerComponent', () => {
  let component: AdministrarAlquilerComponent;
  let fixture: ComponentFixture<AdministrarAlquilerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrarAlquilerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrarAlquilerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
