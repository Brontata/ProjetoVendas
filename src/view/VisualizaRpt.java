package view;
//IMPORTS

import dao.BancoSql;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class VisualizaRpt {
    /*
    Gera relatório a partir do seu arquivo "Compilado" (*.jasper)
    @param arquivoRpt Nome do arquivo iReport compilado (ex.: arq.jasper) que irá ser usado para gerar a visualização do relaório.
    @param parameter Parâmetro(s) para preencher o SQL da consulta que gera o relatório (caso existam).
    @param titulo Título que aparecerá na borda da janela do relatório.
    @throws Exception Lança uma exceção genérica, para evitar tratar exceções aqui.
    */
    
    public static void geraRelatorio(String arquivoRpt, Map parameter, String titulo) throws Exception {
        Connection conn = BancoSql.getConnection();
        JasperPrint jp = JasperFillManager.fillReport("src/view/reports/" + arquivoRpt, parameter, conn);
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.setTitle(titulo);
        viewer.setVisible(true);
        
        
    }
}
