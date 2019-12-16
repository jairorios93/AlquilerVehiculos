import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServicioAlquiler } from 'src/app/shared/servicios/alquiler/servicio.alquiler'
import { ServicioVehiculo } from 'src/app/shared/servicios/vehiculo/servicio.vehiculo'
import { ServicioUsuario } from 'src/app/shared/servicios/usuario/servicio.usuario'
import { AlquilarVehiculo } from 'src/app/feature/shared/model/alquilar.vehiculo';
import { Vehiculo } from 'src/app/feature/shared/model/vehiculo';
import { Usuario } from 'src/app/feature/shared/model/usuario';

@Component({
  selector: 'app-administrar-alquiler',
  templateUrl: './administrar-alquiler.component.html',
  styleUrls: ['./administrar-alquiler.component.css']
})
export class AdministrarAlquilerComponent implements OnInit {

  usuario: Usuario = new Usuario;
  existeUsuario: boolean = false;
  vehiculo: Vehiculo = new Vehiculo;
  existeVehiculo: boolean = false;
  alquilarVehiculo: AlquilarVehiculo = new AlquilarVehiculo;
  form: NgForm;
  minDate: Date = new Date;


  constructor(private servicioAlquiler: ServicioAlquiler, private servicioUsuario: ServicioUsuario, private servicioVehiculo: ServicioVehiculo) { }

  ngOnInit() {
  }

  OnSubmitRegistrar(form: NgForm) {
    if (!this.alquilarVehiculo.fechaInicio || !this.alquilarVehiculo.fechaFin) {
      alert('Ingrese una fecha inicio y fecha fin');
    } else {
      if (this.existeUsuario && this.existeVehiculo) {
        const enviarAlquiler: AlquilarVehiculo = {
          id: 1,
          usuario: this.alquilarVehiculo.usuario,
          vehiculo: this.alquilarVehiculo.vehiculo,
          fechaInicio: this.alquilarVehiculo.fechaInicio,
          fechaFin: this.alquilarVehiculo.fechaFin,
          estado: true,
          valor: this.alquilarVehiculo.vehiculo.precio
        };
        if (this.servicioAlquiler.alquilar(enviarAlquiler)) {
          this.limpiarVentana();
        }
    } else {
      alert('Busque un usuario y un vehiculo');
     }
    }
  }

  buscarUsuario(form: NgForm) {
    if (!this.usuario.cedula) {
      alert('Ingrese una cedula');
    } else {
      this.usuario =  this.servicioUsuario.buscar(this.usuario.cedula);
      if (this.usuario != null) {
          this.alquilarVehiculo.usuario = this.usuario;
          this.alquilarVehiculo.usuario.cedula = this.usuario.cedula;
          this.alquilarVehiculo.usuario.nombres = this.usuario.nombres;
          this.alquilarVehiculo.usuario.apellidos = this.usuario.apellidos;
          this.alquilarVehiculo.usuario.fechaNacimiento = this.usuario.fechaNacimiento;
          this.existeUsuario = true;
        } else {
          this.existeUsuario = false;
        }
      }
  }

  buscarVehiculo(form: NgForm) {
    if (!this.vehiculo.placa) {
      alert('Ingrese una placa');
    } else {
      this.vehiculo = this.servicioVehiculo.buscar(this.vehiculo.placa);
      if (this.vehiculo != null) {
        this.alquilarVehiculo.vehiculo = this.vehiculo;
        this.alquilarVehiculo.vehiculo.id = this.vehiculo.id;
        this.alquilarVehiculo.vehiculo.placa = this.vehiculo.placa;
        this.alquilarVehiculo.vehiculo.modelo = this.vehiculo.modelo;
        this.alquilarVehiculo.vehiculo.marca = this.vehiculo.marca;
        this.alquilarVehiculo.vehiculo.color = this.vehiculo.color;
        this.alquilarVehiculo.vehiculo.precio = this.vehiculo.precio;
        this.existeVehiculo = true;
      } else {
        this.existeVehiculo = false;
      }
    }
  }

  OnSubmitDevolverVehiculo(form: NgForm) {
    this.servicioAlquiler.devolver(this.vehiculo.placa);
  }

  limpiarVentana() {
    this.alquilarVehiculo = new AlquilarVehiculo;
    this.usuario = new Usuario;
    this.vehiculo = new Vehiculo;
    this.existeVehiculo = false;
    this.existeUsuario = false;
  }

  onChancgeFecha() {
    this.alquilarVehiculo.fechaFin = null;
  }
}
