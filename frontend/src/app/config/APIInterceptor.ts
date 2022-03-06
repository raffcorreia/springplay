import {Injectable, isDevMode} from '@angular/core';
import {HttpEvent, HttpInterceptor, HttpHandler, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class APIInterceptor implements HttpInterceptor {

    private readonly BASE_URL: string = '/api/experience';

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let isRunningAsDev = isDevMode();
        console.log("Intercepting( isDevMode = " + isRunningAsDev + " )...")

        const apiReq = req.clone({url: this.BASE_URL + `${req.url}`});

        if(isRunningAsDev) {
            apiReq.headers.append("Basic", "YWRtaW46YWRtaW4=");
        }

        return next.handle(apiReq);
    }
}
