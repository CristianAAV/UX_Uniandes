import { Component, OnInit } from '@angular/core';
import { Trabajador, TrabajadorService } from '../../services/trabajador.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-trabajadores',
  templateUrl: './lista-trabajadores.component.html',
  styleUrl: './lista-trabajadores.component.scss'
})
export class ListaTrabajadoresComponent implements OnInit {
  trabajadores: Trabajador[] = [];

  constructor(
    private trabajadorService: TrabajadorService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.trabajadorService.obtenerTrabajadores().subscribe(trabajadores => this.trabajadores = trabajadores);
  }

  verDetalles(id: number): void {
    this.router.navigate(['/trabajadores', id]);
  }
}
