package io.gmenezes.relatorio_pdf.core.utils;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import io.gmenezes.relatorio_pdf.core.domain.enums.PDFReportFontPaths;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PDFReportFormater {

    private static PDFReportUtils pdfUtils = new PDFReportUtils();
    

    public static void setLeftHeaderFormat(Canvas canvas) throws IOException {
        DeviceRgb collor = pdfUtils.getFontCollor();
        PdfFont font = getCustomFont(PDFReportFontPaths.BOLD_FONT_PATH.getFontPath());
        canvas.setFont(font).setFontSize(9.0f);
        canvas.setFontColor(collor);
    }

    public static void setFontHeaderFormat(Canvas canvas) throws IOException {
        PdfFont font = getCustomFont(PDFReportFontPaths.REGULAR_FONT_PATH.getFontPath());
        canvas.setFont(font).setFontSize(9.0f);
        canvas.setFontColor(ColorConstants.BLACK);
        
    }

    public static Table setTableFormat(int numOfColumns) throws IOException  {
        PdfFont font = getCustomFont(PDFReportFontPaths.REGULAR_FONT_PATH.getFontPath());
        return new Table(numOfColumns)
                    .setWidth(774f) 
                    .setFont(font)
                    .setFontSize(7.5f)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setAutoLayout()
                    .useAllAvailableWidth()
                    .setBorder(null);
    }

    public static PdfFont getCustomFont(String fontPath) throws IOException {
        return PdfFontFactory.createFont(fontPath, PdfEncodings.WINANSI, 
                                PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);

    }
}
