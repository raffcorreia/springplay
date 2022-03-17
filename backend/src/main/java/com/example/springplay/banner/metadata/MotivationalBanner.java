package com.example.springplay.banner.metadata;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MotivationalBanner extends BannerMetadata {

    public MotivationalBanner() {
        super(BannerType.MOTIVATIONAL);
    }

    private String text;
}
