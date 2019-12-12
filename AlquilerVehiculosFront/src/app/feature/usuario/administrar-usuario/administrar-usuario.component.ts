import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BaseService } from 'src/app/core/services/rest.service'
import { Usuario } from 'src/app/feature/shared/model/usuario';

@Component({
  selector: 'app-administrar-usuario',
  templateUrl: './administrar-usuario.component.html',
  styleUrls: ['./administrar-usuario.component.css']
})
export class AdministrarUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario;
  form: NgForm;

  constructor(private baseService: BaseService, private router: Router) { }

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
      this.baseService.queryPost('usuario/registroUsuario', enviarUsuario).subscribe(result => {
        alert('El usuario ha sido registrado')
        this.limpiarVentana();
      }, err => {
        alert(err.error.message);
      });

    }
  }

  OnSubmitBuscar(form: NgForm) {
    if (!this.usuario.cedula) {
      alert('Ingrese una cedula');
    } else {
      this.baseService.queryGet('usuario/busquedaUsuario', this.usuario.cedula).subscribe(result => {
      if (result != null) {
        this.usuario.cedula = result['cedula'];
        this.usuario.nombres = result['nombres'];
        this.usuario.apellidos = result['apellidos'];
        this.usuario.fechaNacimiento = result['fechaNacimiento'];
      } else {
        alert('No se encuentra informacion');
      }
    }, err => {
        alert(err.error.message);
    });
   }
  }

  limpiarVentana() {
    this.usuario = new Usuario;
  }

}
