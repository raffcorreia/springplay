package com.example.springplay.banner.metadata;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ErrorBanner extends BannerMetadata {

    public ErrorBanner() {
        super(BannerType.ERROR);
    }

    private String text;
}
