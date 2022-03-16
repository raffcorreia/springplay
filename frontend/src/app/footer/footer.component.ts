import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {MotivationalBannerComponent} from "./motivational-banner/motivational-banner.component";
import {MsgImgBannerComponent} from "./msg-img-banner/msg-img-banner.component";
import {QABannerComponent} from "./qabanner/qabanner.component";
import {ImgBannerComponent} from "./img-banner/img-banner.component";
import {ErrorBannerComponent} from "./error-banner/error-banner.component";
import {BannerType} from "./banner.type";
import {StompClientService} from "../services/stomp/stomp-client.service";
import {BannerMessage} from "./banner.message";

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

  constructor(private CFR: ComponentFactoryResolver,
              private stompService: StompClientService
  ) { }

  ngOnInit(): void {
    this.stompService.setupSocketConnection(EVENT_NAME_SPRING);

    this.stompService.msgReceived.subscribe( response => {
      let message: BannerMessage = JSON.parse(response);
      this.updateBanner(message);
    })
  }

  ngAfterViewInit(): void {

    this.replaceBanner({ type: BannerType.MOTIVATIONAL, text: "Manually created on load"});
    setTimeout(() => {
      console.log('sleep 1');
      this.replaceBanner({ type: BannerType.MSG_IMG, text: "Manually created on load again!!!"});
    }, 2000);
  }

  private updateBanner(message: BannerMessage) {
    this.replaceBanner(message)
  }

  private replaceBanner(message: BannerMessage) {
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
