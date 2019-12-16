import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServicioVehiculo } from 'src/app/shared/servicios/vehiculo/servicio.vehiculo'
import { Vehiculo } from 'src/app/feature/shared/model/vehiculo';

@Component({
  selector: 'app-administrar-vehiculo',
  templateUrl: './administrar-vehiculo.component.html',
  styleUrls: ['./administrar-vehiculo.component.css']
})
export class AdministrarVehiculoComponent implements OnInit {

  constructor(private servicioVehiculo: ServicioVehiculo) { }

  vehiculo: Vehiculo = new Vehiculo;

  ngOnInit() {
  }

  form: NgForm;

  OnSubmitRegistrar(form: NgForm) {
    if (!this.vehiculo.placa || !this.vehiculo.precio) {
      alert('Ingrese una placa y un precio');
    } else {
      const enviarVehiculo: Vehiculo = {
        id: 1,
        placa: this.vehiculo.placa,
        modelo: this.vehiculo.modelo,
        marca: this.vehiculo.marca,
        color: this.vehiculo.color,
        precio: this.vehiculo.precio
      };
      console.log(this.servicioVehiculo.registrar(enviarVehiculo));
     /* if (this.servicioVehiculo.registrar(enviarVehiculo)) {
        this.limpiarVentana();
      }**/
    }
  }

  OnSubmitBuscar(form: NgForm) {
    if (!this.vehiculo.placa) {
      alert('Ingrese una placa');
    } else {
      this.vehiculo = this.servicioVehiculo.buscar(this.vehiculo.placa);
      if (this.vehiculo != null) {
        this.vehiculo = this.vehiculo;
        this.vehiculo.id = this.vehiculo.id;
        this.vehiculo.placa = this.vehiculo.placa;
        this.vehiculo.modelo = this.vehiculo.modelo;
        this.vehiculo.marca = this.vehiculo.marca;
        this.vehiculo.color = this.vehiculo.color;
        this.vehiculo.precio = this.vehiculo.precio;
      }
    }
  }

  limpiarVentana() {
    this.vehiculo = new Vehiculo;
  }

}
