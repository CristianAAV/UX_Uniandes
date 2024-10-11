import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

export interface Grupo {
  id: number;
  nombre: string;
  descripcion: string;
  imagen: string;
}

@Injectable({
  providedIn: 'root'
})
export class GrupoService {
  private grupos: Grupo[] = [
    { id: 1, nombre: 'Vendedores de Golosinas', descripcion: 'Grupo de 10 personas entre 20 y 25 años', imagen:'assets/images/grupo01.png' },
    { id: 2, nombre: 'Vendedores de Aceites', descripcion: 'Grupode 7 personas de mujeres menores de 28 años', imagen:'assets/images/grupo02.png' },
    { id: 3, nombre: 'Vendedores de Licor', descripcion: 'Grupo de 5 personas, todos varones', imagen:'assets/images/grupo03.png' }
  ];

  constructor() { }

  obtenerGrupos(): Observable<Grupo[]> {
    return of(this.grupos);
  }

  obtenerGrupoPorId(id: number): Observable<Grupo | undefined> {
    const trabajador = this.grupos.find(t => t.id === id);
    return of(trabajador);
  }

}
