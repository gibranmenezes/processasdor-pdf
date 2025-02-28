package io.gmenezes.relatorio_pdf.core.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.kernel.colors.DeviceRgb;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PDFReportUtils {

    
    public List<String> getRepasseReportColumns() {
       return List.of("Data",   
                        "Estabelecimento",
                        "Valor Repasse",
                        "Desconto",
                        "Valor Final",
                        "Status",
                        "Conta",
                        "Código EC");
    }

    public float[] getColumnsWidth() {
        return new float[]{7.5f, 30.0f, 7.5f, 7.5f, 7.5f}; // percentual dos valores
    }

    public int getRepasseReportNumOfColumns() { return 8; }

    public DeviceRgb getTableHeaderBGCollor() {
        return new DeviceRgb(0x28, 0xC5, 0xD6);
    }

    public DeviceRgb getFooterBGCollor() {
        return new DeviceRgb(0xf3, 0xf6, 0xf8);
    }

    public DeviceRgb getFontCollor() {
        return new DeviceRgb(0x2a, 0x22, 0x64);
    }

    

}
