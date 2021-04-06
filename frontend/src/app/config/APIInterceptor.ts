import {Injectable} from '@angular/core';
import {HttpEvent, HttpInterceptor, HttpHandler, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class APIInterceptor implements HttpInterceptor {

    private readonly BASE_URL: string = '/api/experience';

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        console.log("Intercepting...")
        const apiReq = req.clone({url: this.BASE_URL + `${req.url}`});
        return next.handle(apiReq);
    }
}
