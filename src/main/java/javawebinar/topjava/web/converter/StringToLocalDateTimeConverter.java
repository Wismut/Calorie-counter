package javawebinar.topjava.web.converter;

import javawebinar.topjava.util.TimeUtil;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;


public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String param) {
        return TimeUtil.toDateTime(param);
    }
}
