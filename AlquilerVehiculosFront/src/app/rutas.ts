import { Routes } from '@angular/router';
import { MenuComponent } from './shared/menu/menu/menu.component'
import { AdministrarVehiculoComponent } from './feature/vehiculo/administrar-vehiculo/administrar-vehiculo.component'
import { AdministrarUsuarioComponent } from './feature/usuario/administrar-usuario/administrar-usuario.component'
import { AdministrarAlquilerComponent } from './feature/alquiler/administrar-alquiler/administrar-alquiler.component'

export const appRutas: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: MenuComponent },
  { path: "administrar-vehiculos", component: AdministrarVehiculoComponent },
  { path: "administrar-usuarios", component: AdministrarUsuarioComponent },
  { path: "administrar-alquiler", component: AdministrarAlquilerComponent }
]
