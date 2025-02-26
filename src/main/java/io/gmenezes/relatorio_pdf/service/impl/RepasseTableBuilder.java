package io.gmenezes.relatorio_pdf.service.impl;

import java.util.List;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import io.gmenezes.relatorio_pdf.core.domain.dto.RepassePDFReport;
import io.gmenezes.relatorio_pdf.core.domain.enums.RepassePDFColumns;
import io.gmenezes.relatorio_pdf.service.CustomTableBuilder;

public class RepasseTableBuilder implements CustomTableBuilder<RepassePDFReport> {

    private Table table;
    private static final Integer COLUMNS_NUMBER = 8;

    public RepasseTableBuilder() {
      this.table = new Table(COLUMNS_NUMBER).useAllAvailableWidth().setFontSize(10);
      this.table.setAutoLayout();
      this.table.setBorder(null);
    }

    @Override
    public void addHeader() {
       List<String> columns = RepassePDFColumns.getRepasseColumns();

       columns.stream()
              .map(col -> new Cell()
                          .add(new Paragraph(col).setBold())
                          .setTextAlignment(TextAlignment.LEFT)
                          .setBackgroundColor(ColorConstants.BLUE)
                          .setFontColor(ColorConstants.BLACK)
                          .setFontSize(5))
              .forEach(table::addHeaderCell);
    }

    @Override
    public void addData(List<RepassePDFReport> data) {
        data.forEach(item -> {
            table.addCell(createCell(item.getData(), TextAlignment.CENTER));
            table.addCell(createCell(item.getEstabelecimento(), TextAlignment.LEFT));
            table.addCell(createCell(String.format("%.2f", item.getValorRepasse()), TextAlignment.RIGHT));
            table.addCell(createCell(String.format("%.2f", item.getDesconto()), TextAlignment.RIGHT));
            table.addCell(createCell(String.format("%.2f", item.getValorFinal()), TextAlignment.RIGHT));
            table.addCell(createCell(item.getStatus(), TextAlignment.CENTER));
            table.addCell(createCell(item.getConta(), TextAlignment.CENTER));
            table.addCell(createCell(item.getCodigoEC(), TextAlignment.CENTER));
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
                .setBorder(null);
    }
    

}
