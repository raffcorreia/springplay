import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {XssExperienceComponent} from './xss-experience/xss-experience.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HeaderComponent} from './header/header.component';
import {SqlInjectionComponent} from './sql-injection/sql-injection.component';
import {APIInterceptor} from "./config/APIInterceptor";
import {LoginComponent} from './login/login.component';
import { WebSocketComponent } from './web-socket/web-socket.component';

@NgModule({
    declarations: [
        AppComponent,
        XssExperienceComponent,
        HeaderComponent,
        SqlInjectionComponent,
        LoginComponent,
        WebSocketComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
    ],
    providers: [{
        provide: HTTP_INTERCEPTORS,
        useClass: APIInterceptor,
        multi: true,
    }],
    bootstrap: [AppComponent]
})
export class AppModule {
}
