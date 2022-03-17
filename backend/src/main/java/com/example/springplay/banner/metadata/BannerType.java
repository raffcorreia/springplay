package com.example.springplay.banner.metadata;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum BannerType {

    MOTIVATIONAL(0),
    MSG_IMG(1),
    QA(2),
    IMG(3),
    ERROR(4);

    @JsonValue
    private final Integer code;

    BannerType(Integer code) {
        this.code = code;
    }
}
