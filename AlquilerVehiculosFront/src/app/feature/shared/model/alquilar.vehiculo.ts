import { Usuario } from './usuario';
import { Vehiculo } from './vehiculo';

export class AlquilarVehiculo {
  id: number;
  usuario: Usuario;
  vehiculo: Vehiculo;
  fechaInicio: Date;
  fechaFin: Date;
  estado: boolean;
  valor: number;
}
