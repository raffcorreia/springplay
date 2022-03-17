import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {MotivationalBannerComponent} from "./motivational-banner/motivational-banner.component";
import {MsgImgBannerComponent} from "./msg-img-banner/msg-img-banner.component";
import {QABannerComponent} from "./qabanner/qabanner.component";
import {ImgBannerComponent} from "./img-banner/img-banner.component";
import {ErrorBannerComponent} from "./error-banner/error-banner.component";
import {StompClientService} from "../services/stomp/stomp-client.service";
import {BannerMessage} from "./banner.message";
import {RxStompService} from "../services/stomp/rx-stomp.service";

const EVENT_NAME_SPRING = "/topic/banners";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.sass']
})
export class FooterComponent implements OnInit {
  @ViewChild("viewContainerRef", { read: ViewContainerRef })
  private VCR: ViewContainerRef;
  private components: Array<any> = [
    MotivationalBannerComponent, MsgImgBannerComponent, QABannerComponent, ImgBannerComponent, ErrorBannerComponent
  ];
  private stompService: StompClientService = new StompClientService(this.rxStompService);

  constructor(private CFR: ComponentFactoryResolver,
              private rxStompService: RxStompService
  ) { }

  ngOnInit(): void {
    this.stompService.setupSocketConnection(EVENT_NAME_SPRING);

    this.stompService.msgReceived.subscribe(response => {
      this.updateBanner(<BannerMessage>response);
    })
  }

  private updateBanner(message: BannerMessage) {
    this.VCR.remove(); //Remove last view

    let componentRef = this.components.find(
      c => c.TYPE == message.type
    );

    let factory = this.CFR.resolveComponentFactory(componentRef);
    let childComponentRef = this.VCR.createComponent(factory);
    let childComponent = <any>childComponentRef.instance;
    childComponent.setMessage(message);
  }
}
