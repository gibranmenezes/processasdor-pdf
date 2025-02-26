package io.gmenezes.relatorio_pdf;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.gmenezes.relatorio_pdf.core.domain.dto.RepassePDFReport;
import io.gmenezes.relatorio_pdf.core.domain.dto.RepasseReportPDFForm;
import io.gmenezes.relatorio_pdf.service.PDFDataProcessorFactory;

@SpringBootApplication
public class RelatorioPdfApplication {

	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
		//SpringApplication.run(RelatorioPdfApplication.class, args);
		List<RepassePDFReport> data = Arrays.asList(
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("01/01/2023", "Loja A", 1000.00, 
            50.00, 950.00, "Pago", "Conta X", "EC001"),
            new RepassePDFReport("02/01/2023", "Loja B", 2000.00, 
            100.00, 1900.00, "Pendente", "Conta Y", "EC002")
            );
        
        var form = new RepasseReportPDFForm();
        form.setDataFim("23-01-2025");
        form.setDataInicio( "22-01-2025");
        form.setEnderecoLinha1("Alameda Xingu, 512 - Andar 3º, 4º e 20º");
        form.setEnderecoLinha2("Alphaville Centro Industr e Empr /Alphaville CEP 06455-030 – Barueri - SP");
        form.setNomeFantasia(null);
        form.setRazaoSocial("Alelo S.A. – CNPJ 04.740.876/0001-25");
        form.setTipoReport("REPASSE");

        PDFDataProcessorFactory generator = new PDFDataProcessorFactory<>();
        
        byte[] pdfBytes = generator.processorFileOnMemory(data,form); 
        
        if (pdfBytes != null) {
            System.out.println("PDF gerado com sucesso! Tamanho: " + pdfBytes.length + " bytes");
            // Aqui você pode fazer o que quiser com o array de bytes, como salvar em um arquivo ou enviar como resposta HTTP
        } else {
            System.out.println("Falha ao gerar o PDF.");
        }
        
    }

}
