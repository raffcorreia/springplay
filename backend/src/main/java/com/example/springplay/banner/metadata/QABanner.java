package com.example.springplay.banner.metadata;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class QABanner extends BannerMetadata {

    public QABanner() {
        super(BannerType.QA);
    }

    private String question;
    private String answer;
}
