import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrabajadorInformeComponent } from './trabajador-informe.component';

describe('TrabajadorInformeComponent', () => {
  let component: TrabajadorInformeComponent;
  let fixture: ComponentFixture<TrabajadorInformeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TrabajadorInformeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TrabajadorInformeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
