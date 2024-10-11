import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trabajador, TrabajadorService } from '../../services/trabajador.service';
import { Informe, InformeService } from '../../services/informe.service';

@Component({
  selector: 'app-trabajador-informe',
  templateUrl: './trabajador-informe.component.html',
  styleUrl: './trabajador-informe.component.scss'
})
export class TrabajadorInformeComponent implements OnInit {
  trabajador: Trabajador | undefined;
  informes: Informe[] = [];

  constructor(
    private route: ActivatedRoute,
    private trabajadorService: TrabajadorService,
    private informeService: InformeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.trabajadorService.obtenerTrabajadorPorId(id).subscribe(trabajador => {
      this.trabajador = trabajador;
      /**/
      this.informeService.obtenerInformesPorIdTrabajador(id).subscribe(informes => this.informes = informes || []);
      /**/
    });
  }

}
