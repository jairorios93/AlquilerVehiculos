import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/rest.service';
import { Vehiculo } from 'src/app/feature/shared/model/vehiculo';

@Injectable()
export class ServicioVehiculo {

  constructor(private baseService: BaseService) { }

  vehiculo: Vehiculo = new Vehiculo;

  registrar(vehiculo: Vehiculo): boolean {
    this.baseService.queryPost('vehiculo', vehiculo).subscribe(result => {
      alert('El vehiculo ha sido registrado');
    }, err => {
      alert(err.error.message);
    });
    return true;
  }

  

  buscar(placa: string): Vehiculo {
    this.baseService.queryGet('vehiculo', placa).subscribe(result => {
      if (result != null) {
        this.vehiculo.id = result['id'];
        this.vehiculo.placa = result['placa'];
        this.vehiculo.modelo = result['modelo'];
        this.vehiculo.marca = result['marca'];
        this.vehiculo.color = result['color'];
        this.vehiculo.precio = result['precio'];
      } else {
        alert('No se encuentra informacion del vehiculo');
      }
    }, err => {
      alert(err.error.message);
    });
    return this.vehiculo;
  }

}
