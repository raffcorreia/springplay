package com.example.springplay.banner.metadata;

public abstract class BannerMetadata {

    private final BannerType type;

    public BannerMetadata(BannerType type) {
        this.type = type;
    }

    public BannerType getType() {
        return this.type;
    };

}
