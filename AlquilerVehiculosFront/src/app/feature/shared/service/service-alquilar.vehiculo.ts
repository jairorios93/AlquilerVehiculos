import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AlquilarVehiculo } from 'src/app/feature/shared/model/alquilar.vehiculo';
import { UrlRuta } from '../urlRuta';

@Injectable()
export class ServiceAlquilarVehiculo {

  constructor(private http: HttpClient, private urlRuta: UrlRuta) {
  }

  readonly route = this.urlRuta.getRuta();

  alquilarVehiculo(alquilarVehiculo: AlquilarVehiculo) {
    const enviarAlquiler: AlquilarVehiculo = {
      id: 1,
      usuario: alquilarVehiculo.usuario,
      vehiculo: alquilarVehiculo.vehiculo,
      fechaInicio: alquilarVehiculo.fechaInicio,
      fechaFin: alquilarVehiculo.fechaFin,
      estado: true,
      valor: alquilarVehiculo.vehiculo.precio
    };

    return this.http.post(this.route + '/alquiler/alquilarVehiculo', enviarAlquiler);
  }

  devolverVehiculo(placa: string) {
    return this.http.get(this.route + '/alquiler/devolverVehiculo/' + placa);
  }


}
