import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServicioUsuario } from 'src/app/shared/servicios/usuario/servicio.usuario';
import { Usuario } from 'src/app/feature/shared/model/usuario';

@Component({
  selector: 'app-administrar-usuario',
  templateUrl: './administrar-usuario.component.html',
  styleUrls: ['./administrar-usuario.component.css']
})
export class AdministrarUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario;
  form: NgForm;

  constructor(private servicioUsuario: ServicioUsuario) { }

  ngOnInit() {
  }

  OnSubmitRegistrar(form: NgForm) {
    if (!this.usuario.cedula || !this.usuario.nombres || !this.usuario.fechaNacimiento) {
      alert('Ingrese la informacion del usuario');
    } else {
      const enviarUsuario: Usuario = {
        cedula: this.usuario.cedula,
        nombres: this.usuario.nombres,
        apellidos: this.usuario.apellidos,
        fechaNacimiento: this.usuario.fechaNacimiento
      };

      if (this.servicioUsuario.registrar(enviarUsuario)) {
        this.limpiarVentana();
      } 
    }
  }

  OnSubmitBuscar(form: NgForm) {
    if (!this.usuario.cedula) {
      alert('Ingrese una cedula');
    } else {
      this.usuario = this.servicioUsuario.buscar(this.usuario.cedula);
      if (this.usuario != null) {
        this.usuario = this.usuario;
        this.usuario.cedula = this.usuario.cedula;
        this.usuario.nombres = this.usuario.nombres;
        this.usuario.apellidos = this.usuario.apellidos;
        this.usuario.fechaNacimiento = this.usuario.fechaNacimiento;
      }
   }
  }

  limpiarVentana() {
    this.usuario = new Usuario;
  }

}
