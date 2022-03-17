package com.example.springplay.banner.metadata;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MsgImgBanner extends BannerMetadata {

    public MsgImgBanner() {
        super(BannerType.MSG_IMG);
    }

    private String text;
    private MimeImageTypes imgType;
    private String img;
}
