import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaTrabajadoresComponent } from './components/lista-trabajadores/lista-trabajadores.component';
import { ListaGruposComponent } from './components/lista-grupos/lista-grupos.component';
import { TrabajadorComponent } from './components/trabajador/trabajador.component';
import { HomeComponent } from './components/home/home.component';
import { TrabajadorInformeComponent } from './components/trabajador-informe/trabajador-informe.component';
import { TrabajadorRecorridoComponent } from './components/trabajador-recorrido/trabajador-recorrido.component';
import { GrupoComponent } from './components/grupo/grupo.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'trabajadores', component: ListaTrabajadoresComponent },
  { path: 'trabajadores/:id', component: TrabajadorComponent },  
  { path: 'trabajadores/:id/informes', component: TrabajadorInformeComponent },  
  { path: 'trabajadores/:id/recorridos', component: TrabajadorRecorridoComponent },  
  { path: 'grupos', component: ListaGruposComponent },
  { path: 'grupos/:id', component: GrupoComponent },  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
