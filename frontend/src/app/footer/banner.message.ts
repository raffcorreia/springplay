import {BannerType} from "./banner.type";

export interface BannerMessage {
    type: BannerType;
    text: string;
}