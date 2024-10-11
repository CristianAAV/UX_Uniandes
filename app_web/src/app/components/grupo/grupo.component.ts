import { Component, OnInit } from '@angular/core';
import { Grupo, GrupoService } from '../../services/grupo.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Trabajador, TrabajadorService } from '../../services/trabajador.service';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styleUrl: './grupo.component.scss'
})
export class GrupoComponent implements OnInit {
  grupo: Grupo | undefined;
  trabajadores: Trabajador[] = [];

  constructor(
    private route: ActivatedRoute,
    private grupoService: GrupoService,
    private trabajdorService: TrabajadorService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.grupoService.obtenerGrupoPorId(id).subscribe(grupo => {
      this.grupo = grupo;
      this.trabajdorService.obtenerTrabajadoresPorIdGrupo(id).subscribe(trabajadores => {
        this.trabajadores = trabajadores || [];
      });
    });
  }

}
