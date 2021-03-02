import { Injectable } from '@angular/core';
import {Xss} from './xss';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class XssService {
  XSS: Xss[];

  constructor() {
    this.XSS = [
      { id: 11, text: 'Dr Nice' },
      { id: 12, text: 'Narco' },
      { id: 13, text: 'Bombasto' },
      { id: 14, text: 'Celeritas' },
      { id: 15, text: 'Magneta' },
      { id: 16, text: 'RubberMan' },
      { id: 17, text: 'Dynama' },
      { id: 18, text: 'Dr IQ' },
      { id: 19, text: 'Magma' },
      { id: 20, text: 'Tornado' }
    ];
  }


  getXssList(): Observable<Xss[]> {
    const xss = of(this.XSS);
    return xss;
  }
}
