package io.gmenezes.relatorio_pdf.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RepassePDFReport {
    private String data;
    private String estabelecimento;
    private double valorRepasse;
    private double desconto;
    private double valorFinal;
    private String status;
    private String conta;
    private String codigoEC;

}
