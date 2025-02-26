package io.gmenezes.relatorio_pdf.service;

import java.util.List;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import io.gmenezes.relatorio_pdf.core.domain.dto.RepassePDFReport;
import com.itextpdf.layout.Document;

public class TableHandler {

    static void add(Document document, List<RepassePDFReport> data) {
        // Definir larguras das colunas (ajuste conforme necessário)
        float[] colWidths = {1.5f, 3f, 2f, 2f, 2f, 2f, 2f, 2f};
        Table table = new Table(colWidths).setFontSize(10);

        // Adicionar cabeçalho da tabela na ordem correta
        table.addHeaderCell(new Cell().add(new Paragraph("Data").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Estabelecimento").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Valor Repasse").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Desconto").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Valor Final").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Status").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Conta").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Código EC").setBold()));

        // Adicionar dados dinâmicos
        for (RepassePDFReport item : data) {
            table.addCell(new Cell().add(new Paragraph(item.getData())));
            table.addCell(new Cell().add(new Paragraph(item.getEstabelecimento())));
            table.addCell(new Cell().add(new Paragraph(String.format("%.2f", item.getValorRepasse()))));
            table.addCell(new Cell().add(new Paragraph(String.format("%.2f", item.getDesconto()))));
            table.addCell(new Cell().add(new Paragraph(String.format("%.2f", item.getValorFinal()))));
            table.addCell(new Cell().add(new Paragraph(item.getStatus())));
            table.addCell(new Cell().add(new Paragraph(item.getConta())));
            table.addCell(new Cell().add(new Paragraph(item.getCodigoEC())));
        }

        document.add(table);
    }

}
