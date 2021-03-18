import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {XssExperienceComponent} from './xss-experience/xss-experience.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'xss-experience',
    pathMatch: 'full'
  },
  {
    path: 'xss-experience',
    component: XssExperienceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
