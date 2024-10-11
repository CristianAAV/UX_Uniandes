import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trabajador, TrabajadorService } from '../../services/trabajador.service';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';

@Component({
  selector: 'app-trabajador-recorrido',
  templateUrl: './trabajador-recorrido.component.html',
  styleUrl: './trabajador-recorrido.component.scss'
})

export class TrabajadorRecorridoComponent  implements OnInit {
  trabajador: Trabajador | undefined;

  markers:any = [];
  display: any;
  center: google.maps.LatLngLiteral = {
    lat: 22.2736308,
    lng: 70.7512555
  };
  zoom = 10;
  
  constructor(
    private route: ActivatedRoute,
    private trabajadorService: TrabajadorService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.trabajadorService.obtenerTrabajadorPorId(id).subscribe(trabajador => this.trabajador = trabajador);
  }
  
  generarAleatorio(): number {
    return Math.floor(Math.random() * (20 - 11)) + 11;
  }

  onDateChange(event: MatDatepickerInputEvent<Date>) {
    let total:number = this.generarAleatorio();
    this.markers = [];
    for(let i = 0; i<= total; i++){
      this.addMarker();
    }    
  }
  

  addMarker() {
    this.markers.push({
      position: {
        lat: this.center.lat + ((Math.random() - 0.5) * 2) / 10,
        lng: this.center.lng + ((Math.random() - 0.5) * 2) / 10,
      },
      label: {
        color: 'red',
        text: 'Marker label ' + (this.markers.length + 1),
      },
      title: 'Marker title ' + (this.markers.length + 1),
      options: { animation: google.maps.Animation.BOUNCE },
    });
  }  

}
