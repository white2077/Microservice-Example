package com.white.product.utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperUtil {
    static ModelMapper modelMapper = new ModelMapper();
    public static <T> T map(Object source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
    public static <T> List<T>  mapList(@NotNull List<?> source, Class<T> targetClass) {
        return source.stream().map(e -> modelMapper.map(e, targetClass)).toList();
    }
    public static void excludeField() {
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    }
}
