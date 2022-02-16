import {Component} from '@angular/core';
import {SocketioService} from "./services/socketio.service";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
})
export class AppComponent {
    title = 'springplay';

    constructor(private socketService: SocketioService) {}

    ngOnInit() {
        this.socketService.setupSocketConnection();
    }

    ngOnDestroy() {
        this.socketService.disconnect();
    }
}
