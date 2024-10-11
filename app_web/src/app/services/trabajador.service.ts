// trabajador.service.ts
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

export interface Trabajador {
  id: number;
  nombre: string;
  correo: string;
  telefono: string;
  puesto: string;
  imagen: string;
  idGrupo: number;
}

@Injectable({
  providedIn: 'root'
})
export class TrabajadorService {

  private trabajadores: Trabajador[] = [
    { id: 1, nombre: 'Juan Pérez', correo:'jperez@gmail.com', telefono:'+54 987-000-234', puesto: 'Vendedor de Vantas', imagen: 'assets/images/varon01.jpg', idGrupo: 1 },
    { id: 2, nombre: 'Ana Gómez', correo:'agomez@gmail.com',telefono:'+54 918-523-897',puesto: 'Vendedor', imagen: 'assets/images/mujer02.jpg', idGrupo: 1},
    { id: 3, nombre: 'Carlos Ramírez', correo:'cramirez@gmail.com',telefono:'+54 922-999-766',puesto: 'Vendedor',imagen: 'assets/images/varon02.jpg', idGrupo: 2},
    { id: 4, nombre: 'Juan Suarez', correo:'jsuarez@gmail.com',telefono:'+54 921-999-923',puesto: 'Supervisor de Ventas',imagen: 'assets/images/varon03.jpg' , idGrupo: 2},
    { id: 5, nombre: 'Maria Morales', correo:'mmorales@gmail.com',telefono:'+54 943-999-731',puesto: 'Vendedor',imagen: 'assets/images/mujer02.jpg', idGrupo: 2},
    { id: 6, nombre: 'Vanessa Chacon', correo:'vchacon@gmail.com',telefono:'+54 987-999-745',puesto: 'Vendedor',imagen: 'assets/images/mujer03.jpg', idGrupo: 2},
    { id: 7, nombre: 'Luisa Vargas', correo:'lvargas@gmail.com',telefono:'+54 999-543-626',puesto: 'Vendedor',imagen: 'assets/images/mujer04.jpg', idGrupo: 3 },
  ];

  constructor() { }

  obtenerTrabajadores(): Observable<Trabajador[]> {
    return of(this.trabajadores);
  }

  obtenerTrabajadorPorId(id: number): Observable<Trabajador | undefined> {
    const trabajador = this.trabajadores.find(t => t.id === id);
    return of(trabajador);
  }

  obtenerTrabajadoresPorIdGrupo(idGrupo: number): Observable<Trabajador[] | undefined> {
    const trabajador = this.trabajadores.filter(t => t.idGrupo === idGrupo);
    return of(trabajador);
  }

}
