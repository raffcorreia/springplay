
export default class FooterUtils {

    static buildImageSrcData(type: MimeImageTypes, base64EncodedImg: string)  {
        if(type && base64EncodedImg) {
            return "data:" + MimeImageTypes[type] + ";base64," + atob(base64EncodedImg)
        }
        return "";
    }
}

export enum MimeImageTypes {
    APNG = "image/apng",
    AVIF = "image/avif",
    BMP = "image/bmp",
    GIF = "image/gif",
    JPEG = "image/jpeg",
    PNG = "image/png",
    SVG_XML = "image/svg+xml",
    TIFF = "image/tiff",
    WEBP = "image/webp",
    X_ICON = "image/x-icon"
}