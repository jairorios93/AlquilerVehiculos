import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BaseService } from 'src/app/core/services/rest.service'
import { Vehiculo } from 'src/app/feature/shared/model/vehiculo';

@Component({
  selector: 'app-administrar-vehiculo',
  templateUrl: './administrar-vehiculo.component.html',
  styleUrls: ['./administrar-vehiculo.component.css']
})
export class AdministrarVehiculoComponent implements OnInit {

  vehiculo: Vehiculo = new Vehiculo;
  form: NgForm;

  constructor(private baseService : BaseService, private router: Router) { }

  ngOnInit() {
  }

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
      this.baseService.queryPost('vehiculo/registrarVehiculo', enviarVehiculo).subscribe(result => {
        alert('El vehiculo ha sido registrado');
        this.limpiarVentana();
      }, err => {
        alert(err.error.message);
      });

    }
  }

  OnSubmitBuscar(form: NgForm) {
    if (!this.vehiculo.placa) {
      alert('Ingrese una placa');
    } else {
      this.baseService.queryGet('vehiculo/buscarVehiculo', this.vehiculo.placa).subscribe(result => {
      if (result != null) {
        this.vehiculo.id = result['id'];
        this.vehiculo.placa = result['placa'];
        this.vehiculo.modelo = result['modelo'];
        this.vehiculo.marca = result['marca'];
        this.vehiculo.color = result['color'];
        this.vehiculo.precio = result['precio'];
      } else {
        alert('No se encuentra informacion');
      }
    }, err => {
        alert(err.error.message);
    });
    }
  }

  limpiarVentana() {
    this.vehiculo = new Vehiculo;
  }

}
