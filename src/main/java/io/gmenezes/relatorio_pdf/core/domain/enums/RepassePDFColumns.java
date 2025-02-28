package io.gmenezes.relatorio_pdf.core.domain.enums;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RepassePDFColumns {
    
    DATA("Data"),
    ESTABELECIMENTO("Estabelecimento"),
    VALOR_REPASSE("Valor Repasse"),
    DESCONTO("Desconto"),
    VALOR_FINAL("Valor Final"),
    STATUS("Status"),
    CONTA("Conta"),
    CODIGO_EC("Código EC");

    private String value;

    public static List<String> getRepasseColumns() {
       return List.of(RepassePDFColumns.values())
                        .stream()
                        .map(RepassePDFColumns::getValue)
                        .toList();
    }

}
