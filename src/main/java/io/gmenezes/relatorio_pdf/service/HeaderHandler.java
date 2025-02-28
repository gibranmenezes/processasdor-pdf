package io.gmenezes.relatorio_pdf.service;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.TextAlignment;

import io.gmenezes.relatorio_pdf.core.domain.dto.RepasseReportPDFForm;
import io.gmenezes.relatorio_pdf.core.utils.PDFReportFormater;
import io.gmenezes.relatorio_pdf.core.utils.PDFReportUtils;


@Component
public class HeaderHandler implements IEventHandler{

    private RepasseReportPDFForm form;
    private PDFReportUtils pdfUtils = new PDFReportUtils();
    private static final String IMAGE_PATH = "src/main/resources/static/veloe_header.png";

    public HeaderHandler(RepasseReportPDFForm form) {
        this.form = form;
    }

    @Override
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfPage page = docEvent.getPage();
        PdfCanvas pdfCanvas = new PdfCanvas(page);
        Rectangle pageSize = page.getPageSize();
        PdfDocument pdf = docEvent.getDocument();
       
        if(pdf.getPageNumber(page) == 1) {
            try {
                drawLeftHeader(pdfCanvas, pageSize);
                drawRightHeader(pdfCanvas, pageSize);
                drawFooterRectangle(pdfCanvas, pageSize);
            } catch (IOException e) {
                
                e.printStackTrace();
            }          
        }      
        
    }

    private void drawRightHeader(PdfCanvas pdfCanvas,   Rectangle pageSize) throws IOException {
        Canvas canvas = new Canvas(pdfCanvas, pageSize);

        Image img = new Image(ImageDataFactory.create(IMAGE_PATH));
        img.scaleToFit(100, 100);
        canvas.add(img.setFixedPosition(pageSize.getWidth() - 140, pageSize.getTop() - 100));

        float startYRight = pageSize.getTop() - 120;
        float positionRight = pageSize.getWidth() - 50;

        PDFReportFormater.setLeftHeaderFormat(canvas);
        canvas.showTextAligned("RAZÃO SOCIAL:", positionRight, startYRight, TextAlignment.RIGHT);
               
        PDFReportFormater.setFontHeaderFormat(canvas);
        canvas.showTextAligned(form.getRazaoSocial(), positionRight, startYRight - 15, TextAlignment.RIGHT);

        PDFReportFormater.setLeftHeaderFormat(canvas);
        canvas.showTextAligned("ENDEREÇO", positionRight, startYRight - 40, TextAlignment.RIGHT);

        PDFReportFormater.setFontHeaderFormat(canvas);
        canvas.showTextAligned(form.getEnderecoLinha1(), positionRight, startYRight - 55, TextAlignment.RIGHT);
        canvas.showTextAligned(form.getEnderecoLinha2(), positionRight, startYRight - 70, TextAlignment.RIGHT);

        canvas.close();

    }

    private void drawLeftHeader(PdfCanvas pdfCanvas,   Rectangle pageSize) throws IOException {
        Canvas canvas = new Canvas(pdfCanvas, pageSize);

        float startYLeft = pageSize.getTop() - 38;

        PDFReportFormater.setFontHeaderFormat(canvas);
        canvas.showTextAligned(form.getTipoReport(), 34, startYLeft, TextAlignment.LEFT);
        PDFReportFormater.setFontHeaderFormat(canvas);
        canvas.showTextAligned("NOME FANTASIA EC: " + form.getNomeFantasia(), 34, startYLeft - 15, TextAlignment.LEFT);
        PDFReportFormater.setFontHeaderFormat(canvas);
        canvas.showTextAligned("PERÍODO INFORMADO: De " + form.getDataInicio() + " até " + form.getDataFim(), 
        34, startYLeft - 30, TextAlignment.LEFT);
        canvas.close();
    }

    private void drawFooterRectangle(PdfCanvas pdfCanvas, Rectangle pageSize) {
        DeviceRgb bgCollor = pdfUtils.getFooterBGCollor();
        // Define a largura da "tabela" conforme sua lógica
        float tableWidth = pageSize.getWidth() - 72;
        // Calcula a posição X para centralizar essa área na página
        float tableX = (pageSize.getWidth() - tableWidth) / 2;
        // Ajuste a posição Y para criar um espaço entre o header e o footer
        float startYFooter = pageSize.getTop() - 250;  // mais afastado para dar espaço
        // Aumente a altura do retângulo para evitar que ele fique "esmagado"
        float rectHeight = 45f;  // aumente conforme necessário
        
        pdfCanvas.saveState();
        pdfCanvas.setFillColor(bgCollor);
        pdfCanvas.setLineWidth(0);
        pdfCanvas.rectangle(tableX, startYFooter, tableWidth, rectHeight);
        pdfCanvas.fill();
        pdfCanvas.restoreState();
    }
    
}
