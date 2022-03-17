package com.example.springplay.banner.metadata;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ImgBanner extends BannerMetadata {

    public ImgBanner() {
        super(BannerType.IMG);
    }

    private MimeImageTypes imgType;
    private String wideImg;
}
