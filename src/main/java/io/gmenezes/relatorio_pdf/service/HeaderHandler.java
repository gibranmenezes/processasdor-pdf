package io.gmenezes.relatorio_pdf.service;

import java.net.MalformedURLException;


import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
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


public class HeaderHandler implements IEventHandler{

    private RepasseReportPDFForm form;
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
                drawFooterLine(pdfCanvas, pageSize);
            } catch (MalformedURLException e) {
                
                e.printStackTrace();
            }          
        }      
        
    }

    private void drawRightHeader(PdfCanvas pdfCanvas,   Rectangle pageSize) throws MalformedURLException {
        Canvas canvas = new Canvas(pdfCanvas, pageSize);

        Image img = new Image(ImageDataFactory.create(IMAGE_PATH));
        img.scaleToFit(100, 100);
        canvas.add(img.setFixedPosition(pageSize.getWidth() - 115, pageSize.getTop() - 100));

        float startYRight = pageSize.getTop() - 130;
        float positionRight = pageSize.getWidth() - 36;

        canvas.showTextAligned("RAZÃO SOCIAL:", positionRight, startYRight, TextAlignment.RIGHT).setFontColor(ColorConstants.BLUE);
        canvas.showTextAligned(form.getRazaoSocial(), positionRight, startYRight - 15, TextAlignment.RIGHT);

        canvas.showTextAligned("ENDEREÇO", positionRight, startYRight - 40, TextAlignment.RIGHT).setFontColor(ColorConstants.BLUE);
        canvas.showTextAligned(form.getEnderecoLinha1(), positionRight, startYRight - 55, TextAlignment.RIGHT);
        canvas.showTextAligned(form.getEnderecoLinha2(), positionRight, startYRight - 70, TextAlignment.RIGHT);

        canvas.close();

    }

    private void drawLeftHeader(PdfCanvas pdfCanvas,   Rectangle pageSize) throws MalformedURLException {
        Canvas canvas = new Canvas(pdfCanvas, pageSize);

        float startYLeft = pageSize.getTop() - 38;

        canvas.showTextAligned(form.getTipoReport(), 34, startYLeft, TextAlignment.LEFT);
        canvas.showTextAligned("NOME FANTASIA EC: " + form.getNomeFantasia(), 34, startYLeft - 15, TextAlignment.LEFT);
        canvas.showTextAligned("PERÍODO INFORMADO: De " + form.getDataInicio() + " até " + form.getDataFim(), 
        34, startYLeft - 30, TextAlignment.LEFT);
        canvas.close();
    }

    private void drawFooterLine(PdfCanvas pdfCanvas, Rectangle pageSize) {
        Canvas canvas = new Canvas(pdfCanvas, pageSize);
        float startYFooter = pageSize.getTop() - 230;
        float tableWidth = pageSize.getWidth() - 68;

        canvas.add(
            new com.itextpdf.layout.element.Cell()
                .setWidth(tableWidth)
                .setHeight(10) 
                .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                .setFixedPosition(36, startYFooter, pageSize.getWidth() - 68)
        );

        canvas.close();
    }

}
