import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {MotivationalBannerComponent} from "./motivational-banner/motivational-banner.component";
import {MsgImgBannerComponent} from "./msg-img-banner/msg-img-banner.component";
import {QABannerComponent} from "./qabanner/qabanner.component";
import {ImgBannerComponent} from "./img-banner/img-banner.component";
import {ErrorBannerComponent} from "./error-banner/error-banner.component";
import {BannerType} from "./banner.type";

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

  constructor(private CFR: ComponentFactoryResolver) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {

    this.replaceBanner(BannerType.MOTIVATIONAL);
    setTimeout(() => {
      console.log('sleep 1');
      this.replaceBanner(BannerType.MSG_IMG);
    }, 2000);
  }

  private replaceBanner(newType: BannerType) {
    this.VCR.remove(); //Remove last view

    let componentRef = this.components.find(
      c => c.TYPE == newType
    );

    let factory = this.CFR.resolveComponentFactory(componentRef);
    this.VCR.createComponent(factory);
  }
}
