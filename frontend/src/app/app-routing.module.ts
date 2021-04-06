import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {XssExperienceComponent} from './xss-experience/xss-experience.component';
import {SqlInjectionComponent} from './sql-injection/sql-injection.component';

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
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
