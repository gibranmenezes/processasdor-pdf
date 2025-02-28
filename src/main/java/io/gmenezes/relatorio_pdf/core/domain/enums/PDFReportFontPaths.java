package io.gmenezes.relatorio_pdf.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PDFReportFontPaths {

    REGULAR_FONT_PATH("src/main/resources/fonts/Segoe UI.ttf"),
    BOLD_FONT_PATH("src/main/resources/fonts/Segoe UI Bold.ttf");

    private String fontPath;
}
