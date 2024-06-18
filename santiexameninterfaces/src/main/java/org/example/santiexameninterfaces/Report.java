package org.example.santiexameninterfaces;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Report {
    public void descargarreporte() throws SQLException, JRException {
        Connection c = MySQLConnection.getConnection();
        HashMap hm = new HashMap<>();

        var jasperPrint = JasperFillManager.fillReport("Alumno.jasper",hm,c);
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Alumno.pdf"));
        exp.setConfiguration(new SimplePdfExporterConfiguration());
        exp.exportReport();

        System.out.print("Done!");

    }
}
