package io.gmenezes.relatorio_pdf.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RepasseReportPDFForm {

    private String tipoReport;
    private String nomeFantasia;
    private String dataInicio;
    private String dataFim;
    private String razaoSocial;
    private String enderecoLinha1;
    private String enderecoLinha2;

}
