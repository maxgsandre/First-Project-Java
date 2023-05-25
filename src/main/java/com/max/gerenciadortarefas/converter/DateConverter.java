package com.max.gerenciadortarefas.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class DateConverter implements Converter {

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        try {
            return dateFormat.parse(value);
        } catch (ParseException e) {
            throw new ConverterException("Erro na conversão da data", e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        if (!(value instanceof Date)) {
            throw new ConverterException("O valor informado não é uma instância de java.util.Date");
        }

        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        return dateFormat.format((Date) value);
    }
}
