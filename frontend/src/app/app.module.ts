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
import {SocketIOService} from "./services/socketio.service";
import {RxStompService} from "./services/stomp/rx-stomp.service";
import {rxStompServiceFactory} from "./services/stomp/rx-stomp-service-factory";
import { UserComponent } from './user/user.component';
import {DatePipe} from "@angular/common";
import { FooterComponent } from './footer/footer.component';
import { MotivationalBannerComponent } from './footer/motivational-banner/motivational-banner.component';
import { MsgImgBannerComponent } from './footer/msg-img-banner/msg-img-banner.component';
import { QABannerComponent } from './footer/qabanner/qabanner.component';
import { ImgBannerComponent } from './footer/img-banner/img-banner.component';
import { ErrorBannerComponent } from './footer/error-banner/error-banner.component';

@NgModule({
    declarations: [
        AppComponent,
        XssExperienceComponent,
        HeaderComponent,
        SqlInjectionComponent,
        LoginComponent,
        WebSocketComponent,
        UserComponent,
        FooterComponent,
        MotivationalBannerComponent,
        MsgImgBannerComponent,
        QABannerComponent,
        ImgBannerComponent,
        ErrorBannerComponent
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
        multi: true
    },
        SocketIOService,
        DatePipe,
        {
            provide: RxStompService,
            useFactory: rxStompServiceFactory,
        }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
