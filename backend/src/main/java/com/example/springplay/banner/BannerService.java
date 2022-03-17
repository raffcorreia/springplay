package com.example.springplay.banner;

import com.example.springplay.banner.metadata.BannerFactory;
import com.example.springplay.banner.metadata.BannerMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class BannerService {
    public static final String TOPIC_BANNER = "/topic/banners";

    @Autowired
    private BannerFactory bannerFactory;

    @Autowired
    private SimpMessagingTemplate messageTemplate;

    public BannerMetadata postBanner(Map<String, Object> parameters) {
        log.debug("bannerMessages is null = {}", parameters == null);
        log.debug("bannerMessages.size = {}", parameters.size());

        BannerMetadata metadata = bannerFactory.fromPropertyMap(parameters);

        messageTemplate.convertAndSend(TOPIC_BANNER, metadata);

        return metadata;
    }
}
