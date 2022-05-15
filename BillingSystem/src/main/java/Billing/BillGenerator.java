
package Billing;

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


public class BillGenerator {
    
     public static final String fileName = "D:\\BillingProject\\BillingProject\\BillingSystem\\src\\main\\java\\Billing\\report1.jrxml";
     public static final String outFile = "D:\\BillingProject\\BillingProject\\";

    public static void generate(List<BillInfo> invoice, User user, String path) throws FileNotFoundException, JRException {
       
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

    private static int TotalFeeHelper(List<BillInfo> invoice) {
        int totalFee=0;
        for (BillInfo contractCons:invoice){
            totalFee+=contractCons.getTotalFees();
        }
        return totalFee;
    }
    
    
}

