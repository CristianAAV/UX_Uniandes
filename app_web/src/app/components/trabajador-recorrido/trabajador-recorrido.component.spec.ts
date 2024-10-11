import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrabajadorRecorridoComponent } from './trabajador-recorrido.component';

describe('TrabajadorRecorridoComponent', () => {
  let component: TrabajadorRecorridoComponent;
  let fixture: ComponentFixture<TrabajadorRecorridoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TrabajadorRecorridoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TrabajadorRecorridoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
