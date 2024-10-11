import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MenuComponent } from './components/menu/menu.component';
import { ListaTrabajadoresComponent } from './components/lista-trabajadores/lista-trabajadores.component';
import { ListaGruposComponent } from './components/lista-grupos/lista-grupos.component';
import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import { TrabajadorComponent } from './components/trabajador/trabajador.component';
import { HomeComponent } from './components/home/home.component';
import { TrabajadorInformeComponent } from './components/trabajador-informe/trabajador-informe.component';
import { TrabajadorRecorridoComponent } from './components/trabajador-recorrido/trabajador-recorrido.component';
import { GrupoComponent } from './components/grupo/grupo.component';
import { MatIconModule } from '@angular/material/icon'
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {provideNativeDateAdapter} from '@angular/material/core';
import { GoogleMapsModule } from "@angular/google-maps";

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ListaTrabajadoresComponent,
    ListaGruposComponent,
    BreadcrumbComponent,
    TrabajadorComponent,
    HomeComponent,
    TrabajadorInformeComponent,
    TrabajadorRecorridoComponent,
    GrupoComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatIconModule,
    MatInputModule,
    MatDatepickerModule,
    MatFormFieldModule,
    GoogleMapsModule
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    provideNativeDateAdapter()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
