import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { AdministrarVehiculoComponent } from './feature/vehiculo/administrar-vehiculo/administrar-vehiculo.component';
import { MenuComponent } from './shared/menu/menu/menu.component';
import { appRutas } from './rutas';
import { HttpClientModule } from '@angular/common/http';
import { UrlRuta } from './feature/shared/urlRuta';
import { AdministrarUsuarioComponent } from './feature/usuario/administrar-usuario/administrar-usuario.component';
import { AdministrarAlquilerComponent } from './feature/alquiler/administrar-alquiler/administrar-alquiler.component';
import { BaseService } from 'src/app/core/services/rest.service'


@NgModule({
  declarations: [
    AppComponent,
    AdministrarVehiculoComponent,
    MenuComponent,
    AdministrarUsuarioComponent,
    AdministrarAlquilerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRutas),
  ],
  providers: [BaseService, UrlRuta],
  bootstrap: [AppComponent]
})
export class AppModule { }
