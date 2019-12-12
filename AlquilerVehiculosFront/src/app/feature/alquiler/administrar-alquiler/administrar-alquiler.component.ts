import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceUsuario } from 'src/app/feature/shared/service/service-usuario';
import { ServiceVehiculo } from 'src/app/feature/shared/service/service-vehiculo';
import { ServiceAlquilarVehiculo } from 'src/app/feature/shared/service/service-alquilar.vehiculo';
import { AlquilarVehiculo } from 'src/app/feature/shared/model/alquilar.vehiculo';
import { Usuario } from 'src/app/feature/shared/model/usuario';
import { Vehiculo } from 'src/app/feature/shared/model/vehiculo';

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


  constructor(private usuarioServicio: ServiceUsuario, private vehiculoServicio: ServiceVehiculo,
    private alquilarVehiculoServicio: ServiceAlquilarVehiculo, private router: Router) { }

  ngOnInit() {
  }

  OnSubmitRegistrar(form: NgForm) {
    if (!this.alquilarVehiculo.fechaInicio || !this.alquilarVehiculo.fechaFin) {
      alert('Ingrese una fecha inicio y fecha fin');
    } else {
    if (this.existeUsuario && this.existeVehiculo) {
      this.alquilarVehiculoServicio.alquilarVehiculo(this.alquilarVehiculo).subscribe(result => {
        this.limpiarVentana();
      }, err => {
          alert(err.error.message);
      });
    } else {
      alert('Busque un usuario y un vehiculo');
     }
    }
  }

  buscarUsuario(form: NgForm) {
    if (!this.usuario.cedula) {
      alert('Ingrese una cedula');
    } else {
      this.usuarioServicio.buscarUsuario(this.usuario.cedula).subscribe(result => {
        if (result != null) {
          this.alquilarVehiculo.usuario = this.usuario;
          this.alquilarVehiculo.usuario.cedula = result['cedula'];
          this.alquilarVehiculo.usuario.nombres = result['nombres'];
          this.alquilarVehiculo.usuario.apellidos = result['apellidos'];
          this.alquilarVehiculo.usuario.fechaNacimiento = result['fechaNacimiento'];
          this.existeUsuario = true;
        } else {
          this.existeUsuario = false;
          alert('No se encuentra informacion del usuario');
        }
      }, err => {
        this.existeUsuario = false;
        alert(err.error.message);
      });
    }
  }

  buscarVehiculo(form: NgForm) {
    if (!this.vehiculo.placa) {
      alert('Ingrese una placa');
    } else {
      this.vehiculoServicio.buscarVehiculo(this.vehiculo.placa).subscribe(result => {
        if (result != null) {
          this.alquilarVehiculo.vehiculo = this.vehiculo;
          this.alquilarVehiculo.vehiculo.id = result['id'];
          this.alquilarVehiculo.vehiculo.placa = result['placa'];
          this.alquilarVehiculo.vehiculo.modelo = result['modelo'];
          this.alquilarVehiculo.vehiculo.marca = result['marca'];
          this.alquilarVehiculo.vehiculo.color = result['color'];
          this.alquilarVehiculo.vehiculo.precio = result['precio'];
          this.existeVehiculo = true;
        } else {
          this.existeVehiculo = false;
          alert('No se encuentra informacion del vehiculo');
        }
      }, err => {
        this.existeVehiculo = false;
        alert(err.error.message);
      });
    }
  }

  limpiarVentana() {
    this.alquilarVehiculo = new AlquilarVehiculo;
    this.usuario = new Usuario;
    this.vehiculo = new Vehiculo;
    this.existeVehiculo = false;
    this.existeUsuario = false;
  }

  OnSubmitDevolverVehiculo(form: NgForm) {
    this.alquilarVehiculoServicio.devolverVehiculo(this.vehiculo.placa).subscribe(result => {
      alert('El vehiculo ha sido devuelto');
    }, err => {
        alert(err.error.message);
    });
  }

  onChancgeFecha() {
    this.alquilarVehiculo.fechaFin = null;
  }
}
