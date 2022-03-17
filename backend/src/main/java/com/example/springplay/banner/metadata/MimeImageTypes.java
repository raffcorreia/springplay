package com.example.springplay.banner.metadata;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum MimeImageTypes {

    APNG("image/apng"),
    AVIF("image/avif"),
    BMP("image/bmp"),
    GIF("image/gif"),
    JPEG("image/jpeg"),
    PNG("image/png"),
    SVG_XML("image/svg+xml"),
    TIFF("image/tiff"),
    WEBP("image/webp"),
    X_ICON("image/x-icon");

    private final String mimeType;

    MimeImageTypes(String mimeType) {
        this.mimeType = mimeType;
    }
}
