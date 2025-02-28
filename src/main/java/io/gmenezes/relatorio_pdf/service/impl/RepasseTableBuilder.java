package io.gmenezes.relatorio_pdf.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import io.gmenezes.relatorio_pdf.core.domain.dto.RepassePDFReport;
import io.gmenezes.relatorio_pdf.core.utils.PDFReportFormater;
import io.gmenezes.relatorio_pdf.core.utils.PDFReportUtils;
import io.gmenezes.relatorio_pdf.service.CustomTableBuilder;

@Component
public class RepasseTableBuilder implements CustomTableBuilder<RepassePDFReport> {

    private final Table table;    
    private PDFReportUtils reportUtils = new PDFReportUtils();

    public RepasseTableBuilder() throws IOException {
      this.table = PDFReportFormater.setTableFormat(reportUtils.getRepasseReportNumOfColumns());      
    }

    @Override
    public void addHeader() {
       List<String> columns = reportUtils.getRepasseReportColumns();
       DeviceRgb bgCollor = reportUtils.getTableHeaderBGCollor();

       columns.stream()
              .map(col -> new Cell()
                          .add(new Paragraph(col).setFontSize(7.5f))
                          .setBorder(null)
                          .setHeight(30.0f)
                          .setPaddingLeft(20f)
                          .setPaddingRight(2f)
                          .setVerticalAlignment(VerticalAlignment.MIDDLE)
                          .setTextAlignment(TextAlignment.LEFT)
                          .setBackgroundColor(bgCollor)
                          .setFontColor(ColorConstants.BLACK))
                          
              .forEach(table::addHeaderCell);
    }

    @Override
    public void addData(List<RepassePDFReport> data) {
        data.forEach(item -> {
            table.addCell(createCell(item.getData(), TextAlignment.LEFT));
            table.addCell(createCell(item.getEstabelecimento(), TextAlignment.LEFT));
            table.addCell(createCell(String.format("%.2f", item.getValorRepasse()), TextAlignment.LEFT));
            table.addCell(createCell(String.format("%.2f", item.getDesconto()), TextAlignment.LEFT));
            table.addCell(createCell(String.format("%.2f", item.getValorFinal()), TextAlignment.LEFT));
            table.addCell(createCell(item.getStatus(), TextAlignment.LEFT));
            table.addCell(createCell(item.getConta(), TextAlignment.LEFT));
            table.addCell(createCell(item.getCodigoEC(), TextAlignment.LEFT));
        });
    }

    @Override
    public Table build() {
       return table;
    }


    private Cell createCell(String text, TextAlignment alignment) {
        return new Cell()
                .add(new Paragraph(text))
                .setTextAlignment(alignment)
                .setHeight(30f)
                .setBorder(null)
                .setPaddingLeft(20f)
                .setVerticalAlignment(VerticalAlignment.MIDDLE);
    }
    

}
