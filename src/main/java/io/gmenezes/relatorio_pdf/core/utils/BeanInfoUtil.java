package io.gmenezes.relatorio_pdf.core.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class BeanInfoUtil {

     public static <T> List<String> getFieldNames(Class<T> clazz) {
        List<String> fieldNames = new ArrayList<>();
        try {
            // Obtém as informações do bean (objeto)
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);

            // Itera sobre os descritores das propriedades
            for (PropertyDescriptor property : beanInfo.getPropertyDescriptors()) {
                // Ignora o campo "class" (presente em todos os objetos)
                if (!"class".equals(property.getName())) {
                    fieldNames.add(property.getName());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter os nomes dos campos", e);
        }
        return fieldNames;
    }
}
