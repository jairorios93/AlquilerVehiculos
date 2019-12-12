import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Vehiculo } from 'src/app/feature/shared/model/vehiculo';
import { UrlRuta } from '../urlRuta';

@Injectable()
export class ServiceVehiculo {

  constructor(private http: HttpClient, private urlRuta: UrlRuta) {
  }

  readonly route = this.urlRuta.getRuta();

  registrarVehiculo(vehiculo: Vehiculo) {
    const enviarVehiculo: Vehiculo = {
      id: 1,
      placa: vehiculo.placa,
      modelo: vehiculo.modelo,
      marca: vehiculo.marca,
      color: vehiculo.color,
      precio: vehiculo.precio
    };

    return this.http.post(this.route + '/vehiculo/registrarVehiculo', enviarVehiculo);
  }

  buscarVehiculo(placa: string) {
    return this.http.get(this.route + '/vehiculo/buscarVehiculo/' + placa);
  }
}
