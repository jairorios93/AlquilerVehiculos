import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/rest.service';
import { AlquilarVehiculo } from 'src/app/feature/shared/model/alquilar.vehiculo';

@Injectable()
export class ServicioAlquiler {


  constructor(private baseService: BaseService) { }

  alquilar(alquiler: AlquilarVehiculo): boolean {
    this.baseService.queryPost('alquiler', alquiler).subscribe(result => {
      alert('El vehiculo ha sido alquilado');
    }, err => {
      alert(err.error.message);
    });
    return true;
  }


  devolver(placa: string) {
    this.baseService.queryGet('alquiler', placa).subscribe(result => {
      alert('El vehiculo ha sido devuelto');
    }, err => {
      alert(err.error.message);
    });
  }


}
