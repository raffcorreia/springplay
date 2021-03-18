import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { XssExperienceComponent } from './xss-experience/xss-experience.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { SqlInjectionComponent } from './sql-injection/sql-injection.component';

@NgModule({
  declarations: [
    AppComponent,
    XssExperienceComponent,
    HeaderComponent,
    SqlInjectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
