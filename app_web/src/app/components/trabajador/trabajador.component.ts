import { Component, OnInit } from '@angular/core';
import { Trabajador, TrabajadorService } from '../../services/trabajador.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-trabajador',
  templateUrl: './trabajador.component.html',
  styleUrl: './trabajador.component.scss'
})
export class TrabajadorComponent implements OnInit {
  trabajador: Trabajador | undefined;

  constructor(
    private route: ActivatedRoute,
    private trabajadorService: TrabajadorService,
    private router: Router
  ) { }
  
  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.trabajadorService.obtenerTrabajadorPorId(id).subscribe(trabajador => this.trabajador = trabajador);
  }

  verInformes(id: number): void {
    this.router.navigate(['/trabajadores', id, 'informes']);
  }  
  
  verRecorridos(id: number): void {
    this.router.navigate(['/trabajadores', id, 'recorridos']);
  }  

}
