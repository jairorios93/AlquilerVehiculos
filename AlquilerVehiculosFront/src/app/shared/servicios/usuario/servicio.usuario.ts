import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/rest.service';
import { Usuario } from 'src/app/feature/shared/model/usuario';

@Injectable()
export class ServicioUsuario {

  constructor(private baseService: BaseService) {}

  usuario: Usuario = new Usuario;

  registrar(usuario: Usuario): boolean {
    this.baseService.queryPost('usuario', usuario).subscribe(result => {
      alert('El usuario ha sido registrado')
    }, err => {
      alert(err.error.message);
    });
    return true;
  }

  buscar(cedula: number): Usuario {
    this.usuario = new Usuario;
    this.baseService.queryGet('usuario', cedula).subscribe(result => {
      if (result != null) {
        this.usuario.cedula = result['cedula'];
        this.usuario.nombres = result['nombres'];
        this.usuario.apellidos = result['apellidos'];
        this.usuario.fechaNacimiento = result['fechaNacimiento'];
      } else {
        alert('No se encuentra informacion del usuario');
      }
    }, err => {
      alert(err.error.message);
    });
    return this.usuario;
  }

}
