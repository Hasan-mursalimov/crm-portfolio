package ru.crm.portfolio.crmportfolioexample.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Converter
public class StringToListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if(strings == null) return "";
        return String.join(",", strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String joined) {
        if(joined == null) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(joined.split(",")));
    }
}
