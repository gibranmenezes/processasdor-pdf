package io.gmenezes.relatorio_pdf.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import io.gmenezes.relatorio_pdf.core.domain.dto.RepassePDFReport;
import io.gmenezes.relatorio_pdf.core.domain.dto.RepasseReportPDFForm;
import io.gmenezes.relatorio_pdf.service.impl.RepasseTableBuilder;

@Service

public class PDFDataProcessorFactory<T> {

    private static final String PATH = "./relatorio.pdf";

    public byte[] processorFileOnMemory(List<RepassePDFReport> data, RepasseReportPDFForm form) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfDocument pdf = new PdfDocument(new PdfWriter(outputStream));
            Document document = new Document(pdf);

            HeaderHandler headerHandler = new HeaderHandler(form);
            pdf.addEventHandler(PdfDocumentEvent.START_PAGE, headerHandler);

            RepasseTableBuilder tableBuilder = new RepasseTableBuilder();
            tableBuilder.addHeader();
            tableBuilder.addData(data);

            if (pdf.getNumberOfPages() == 0) { 
                document.add(new Paragraph("\n\n\n\n\n\n")); 
            }
           
            Table table = tableBuilder.build();
            table.setMarginTop(80); 
    
            document.add(table);

            document.close();

            saveToFile(outputStream, PATH);

            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar o PDF", e);
        }
    }

    private void saveToFile(ByteArrayOutputStream outputStream, String filePath) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            outputStream.writeTo(fileOutputStream); // Escreve o conteúdo do PDF no arquivo
        }
    }


}
