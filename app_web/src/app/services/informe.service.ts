import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

export interface Informe {
  fechaHora: string;
  informe: string;
  posicion: boolean;
}
export interface InformesTrabajador {
  idTrabajador: number;
  informes: Informe[];
}



@Injectable({
  providedIn: 'root'
})
export class InformeService {

  private informesT1: InformesTrabajador = {
    idTrabajador: 1,
    informes: [
      { fechaHora: '2021-06-01 09:12', informe: 'Visitadas 12 tiendas, cierre de 8 ventas, 4 cotizaciones pendientes.', posicion: true },
      { fechaHora: '2021-06-02 10:15', informe: 'Cuatro productos agotados en 5 tiendas, reportado a inventario.', posicion: false },
      { fechaHora: '2021-06-03 11:26', informe: 'Logradas 10 ventas nuevas, propuestas de descuento aumentaron interés.', posicion: true },
      { fechaHora: '2021-06-04 07:32', informe: 'Vendedor 2 superó el objetivo del día con 15 ventas cerradas.', posicion: false },
      { fechaHora: '2021-06-05 09:26', informe: 'Tres clientes solicitaron demostraciones adicionales para la próxima visita.', posicion: true },
      { fechaHora: '2021-06-06 08:43', informe: 'Dos tiendas solicitaron reabastecimiento urgente de productos populares.', posicion: false },
      { fechaHora: '2021-06-07 09:23', informe: 'Cierre de 7 ventas, dificultades con 3 clientes, seguimiento requerido.', posicion: true },
    ]
  };
  private informesT2: InformesTrabajador = {
    idTrabajador: 2,
    informes: [
      { fechaHora: '2021-06-01 08:33', informe: 'Negociaciones exitosas en 3 tiendas clave, posibles clientes recurrentes.', posicion: true },
      { fechaHora: '2021-06-02 09:40', informe: 'Detectados problemas de precios en dos productos, informada área correspondiente.', posicion: false },
      { fechaHora: '2021-06-03 07:52', informe: 'Se concretaron dos contratos a largo plazo en tiendas locales.', posicion: true },
      { fechaHora: '2021-06-04 11:18', informe: 'Visita exitosa a 6 tiendas, dos clientes nuevos asegurados.', posicion: false },
      { fechaHora: '2021-06-05 10:27', informe: 'Promociones generaron 5 ventas adicionales, clientes satisfechos.', posicion: true },
      { fechaHora: '2021-06-06 08:45', informe: 'Alcanzado el 90% del objetivo semanal, altas expectativas para mañana.', posicion: false },
    ]
  };
  private informesT3: InformesTrabajador = {
    idTrabajador: 3,
    informes: [
      { fechaHora: '2021-06-01 09:20', informe: 'Visitadas 8 tiendas, cerradas 5 ventas y 2 seguimientos agendados.', posicion: true },
      { fechaHora: '2021-06-02 11:30', informe: 'Dos clientes nuevos interesados en productos premium, demostración programada.', posicion: false },
      { fechaHora: '2021-06-03 10:44', informe: 'Se alcanzó el 80% del objetivo diario, posibles ventas futuras.', posicion: true },
      { fechaHora: '2021-06-04 07:24', informe: 'Se establecieron nuevas relaciones comerciales en 2 tiendas.', posicion: true },
      { fechaHora: '2021-06-05 11:40', informe: 'Cuatro tiendas con ventas superiores al promedio, buena retroalimentación.', posicion: false }
    ]
  };

  private informesT4: InformesTrabajador = {
    idTrabajador: 4,
    informes: [
      { fechaHora: '2021-07-11 09:00', informe: 'Cuatro clientes solicitaron cotizaciones, seguimiento programado para la próxima semana.', posicion: true },
      { fechaHora: '2021-07-12 10:00', informe: 'Logradas 7 ventas, promoción generó interés en 3 tiendas adicionales.', posicion: false },
      { fechaHora: '2021-07-13 11:00', informe: 'Reportadas quejas sobre el tiempo de entrega en 2 tiendas.', posicion: true },
      { fechaHora: '2021-07-14 12:00', informe: 'Se agotaron productos en 3 tiendas, reabastecimiento urgente requerido.', posicion: true },
      { fechaHora: '2021-07-15 13:00', informe: 'Alcanzado el objetivo mensual con 10 ventas cerradas hoy.', posicion: true },
    ]
  };
  private informesT5: InformesTrabajador = {
    idTrabajador: 5,
    informes: [
      { fechaHora: '2021-06-01 09:00', informe: 'Dos tiendas manifestaron interés en productos nuevos, muestras solicitadas.', posicion: true },
      { fechaHora: '2021-06-02 08:05', informe: 'Negociaciones exitosas con 3 clientes potenciales en tiendas clave.', posicion: false },
      { fechaHora: '2021-06-03 07:30', informe: 'Se logró un acuerdo de distribución con una tienda local.', posicion: true },
      { fechaHora: '2021-06-04 10:24', informe: 'Se detectaron problemas de precios en 2 productos, ajuste solicitado.', posicion: false },
      { fechaHora: '2021-06-05 11:54', informe: 'Promociones generaron 5 ventas adicionales en tiendas visitadas.', posicion: true },
    ]
  };
  private informesT6: InformesTrabajador = {
    idTrabajador: 6,
    informes: [
      { fechaHora: '2021-06-18 09:00', informe: 'Clientes mostraron gran interés en descuentos, potencial de ventas futuras.', posicion: true },
      { fechaHora: '2021-06-19 08:10', informe: 'Cuatro tiendas reportaron productos defectuosos, se gestionó cambio inmediato.', posicion: false },
      { fechaHora: '2021-06-20 09:55', informe: 'Se realizó seguimiento a 3 clientes, confirmadas 2 ventas adicionales.', posicion: true },
      { fechaHora: '2021-06-21 07:33', informe: 'Visitadas 6 tiendas, 4 ventas cerradas y nuevas cotizaciones solicitadas.', posicion: true },
      { fechaHora: '2021-06-22 11:50', informe: 'Reportadas ventas por debajo del promedio en 3 tiendas, analizar soluciones.', posicion: false },
    ]
  };
  private informesT7: InformesTrabajador = {
    idTrabajador: 7,
    informes: [
      { fechaHora: '2021-06-21 07:30', informe: 'Se concretaron dos acuerdos de venta a largo plazo.', posicion: true },
      { fechaHora: '2021-06-22 08:25', informe: 'Superado el objetivo diario en un 15%, clientes satisfechos.', posicion: false },
      { fechaHora: '2021-06-23 11:12', informe: 'Se estableció contacto con 3 nuevas tiendas para futuras ventas.', posicion: true },
      { fechaHora: '2021-06-24 10:31', informe: 'Tres clientes solicitaron demostraciones adicionales para productos nuevos.', posicion: true },
      { fechaHora: '2021-06-25 09:54', informe: 'Se alcanzó el 85% del objetivo mensual con 8 ventas cerradas hoy.', posicion: false },
    ]
  };

  private informesTrabajadores: InformesTrabajador[] = 
    [   this.informesT1
      , this.informesT2
      , this.informesT3
      , this.informesT4
      , this.informesT5
      , this.informesT6
      , this.informesT7
    ];
  
  constructor() { }

  obtenerInformesPorIdTrabajador(idTrabajador: number): Observable<Informe[] | undefined> {
    const informes = this.informesTrabajadores.find(t => t.idTrabajador === idTrabajador);
    return of(informes?.informes);
  }
}
