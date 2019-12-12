import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from 'src/app/feature/shared/model/usuario';
import { UrlRuta } from '../urlRuta';

@Injectable()
export class ServiceUsuario {

  constructor(private http: HttpClient, private urlRuta: UrlRuta) {
  }

  readonly route = this.urlRuta.getRuta();

  registrarUsuario(usuario: Usuario) {
    const enviarUsuario: Usuario = {
      cedula: usuario.cedula,
      nombres: usuario.nombres,
      apellidos: usuario.apellidos,
      fechaNacimiento: usuario.fechaNacimiento
    };

    return this.http.post(this.route + '/usuario/registrarUsuario', enviarUsuario);
  }

  buscarUsuario(cedula: number) {
    return this.http.get(this.route + '/usuario/buscarUsuario/' + cedula);
  }
}
