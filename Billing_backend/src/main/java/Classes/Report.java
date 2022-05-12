/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author a7med
 */
   

public class Report {
    
     public static final String fileName = "C:\\Users\\a7med\\Downloads\\BillingProject\\Billing_backend\\src\\main\\java\\Classes\\report1.jrxml";
     public static final String outFile = "C:\\Users\\a7med\\Downloads\\BillingProject\\Bills\\";

    public static void generate(List<Bill_info> invoice, User user, String path) throws FileNotFoundException, JRException {
       
        Map<String, Object> parameter  = new HashMap<String, Object>();

        JRBeanCollectionDataSource userCollectionDataSource =
                new JRBeanCollectionDataSource(invoice);
        int total =TotalFeeHelper(invoice);
        parameter.put("studentDataSource", userCollectionDataSource);
        parameter.put("uname", user.getUsername());
        parameter.put("id", user.getNational_id());
        parameter.put("address", user.getAddress());
        parameter.put("title", "Monthly Invoice");
        parameter.put("totalFee", total);

        JasperReport jasperDesign = JasperCompileManager.compileReport(fileName);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperDesign, parameter,new JREmptyDataSource());

        File file = new File(outFile+path);
        OutputStream outputSteam = new FileOutputStream(file);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputSteam);

        System.out.println("Bill Generated Successfully ");
    }

    private static int TotalFeeHelper(List<Bill_info> invoice) {
        int totalFee=0;
        for (Bill_info contractCons:invoice){
            totalFee+=contractCons.getTotalFees();
        }
        return totalFee;
    }
    
    
}
