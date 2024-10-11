import { Component, OnInit } from '@angular/core';
import { Grupo, GrupoService } from '../../services/grupo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-grupos',
  templateUrl: './lista-grupos.component.html',
  styleUrl: './lista-grupos.component.scss'
})
export class ListaGruposComponent  implements OnInit {

  grupos: Grupo[] = [];

  constructor(
    private grupoService: GrupoService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.grupoService.obtenerGrupos().subscribe(grupos => this.grupos = grupos);
  }

  verDetalles(id: number): void {
    this.router.navigate(['/grupos', id]);
  }
}
