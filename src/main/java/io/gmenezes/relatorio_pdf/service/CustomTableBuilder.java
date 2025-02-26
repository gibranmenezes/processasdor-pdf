package io.gmenezes.relatorio_pdf.service;

import java.util.List;

import com.itextpdf.layout.element.Table;

public interface CustomTableBuilder<T> {

     void addHeader();
     void addData(List<T> data);
     Table build();

}
