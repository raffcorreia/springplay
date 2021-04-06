import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {XssExperienceComponent} from './xss-experience/xss-experience.component';
import {SqlInjectionComponent} from './sql-injection/sql-injection.component';
import {WebSocketComponent} from "./web-socket/web-socket.component";

const routes: Routes = [
    {
        path: '',
        redirectTo: 'xss-experience',
        pathMatch: 'full'
    },
    {
        path: 'xss-experience',
        component: XssExperienceComponent
    },
    {
        path: 'sql-injection',
        component: SqlInjectionComponent
    },
    {
        path: 'web-socket',
        component: WebSocketComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
