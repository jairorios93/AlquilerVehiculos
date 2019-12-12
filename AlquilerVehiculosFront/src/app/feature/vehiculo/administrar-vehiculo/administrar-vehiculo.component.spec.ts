import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrarVehiculoComponent } from './administrar-vehiculo.component';

describe('AdministrarVehiculoComponent', () => {
  let component: AdministrarVehiculoComponent;
  let fixture: ComponentFixture<AdministrarVehiculoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrarVehiculoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrarVehiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
