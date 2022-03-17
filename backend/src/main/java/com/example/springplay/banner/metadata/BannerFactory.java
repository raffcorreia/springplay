package com.example.springplay.banner.metadata;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class BannerFactory {

    private static final String TYPE_KEY = "type";

    private final EnumMap<BannerType, BannerMetadata> metadatas = new EnumMap<>(BannerType.class);

    public BannerFactory(List<BannerMetadata> bannerMetadatas) {
        this.metadatas.putAll(bannerMetadatas.stream().collect(Collectors.toMap(BannerMetadata::getType, b -> b)));
    }

    public BannerMetadata fromPropertyMap(Map<String, Object> parameters){
        if(isNull(parameters)) {
            return null;
        }

        Object objType = parameters.get(TYPE_KEY);
        if(isNull(objType)) {
            return null;
        }

        BannerMetadata metadata = metadatas.get(BannerType.valueOf(parameters.get(TYPE_KEY).toString()));

        return buildMetadata(metadata.getClass(), parameters);
    }

    private BannerMetadata buildMetadata(Class<? extends BannerMetadata> clss, Map<String, Object> parameters) {
        try {
            BannerMetadata data = clss.getConstructor().newInstance();

            Field[] fields = clss.getDeclaredFields();
            for (Field field : fields) {
                Object value = parameters.get(field.getName());
                field.setAccessible(true);
                if(field.getType().isEnum()) {
                    extracted(data, field, value);
                } else {
                    field.set(data, value);
                }
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void extracted(BannerMetadata data, Field field, Object value) throws IllegalAccessException {
        field.set(data, Enum.valueOf((Class<Enum>) field.getType(), value.toString()));
    }
}
