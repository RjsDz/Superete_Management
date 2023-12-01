package supermarketproject;




import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Printer {

   

    public static void printPDF(String filePath) {
        try {
            // Create a DocFlavor for PDF
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

            // Create a Print Service
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

            // Create a Print Request Attribute Set
            HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            pras.add(new Copies(1));

            // Create a DocPrintJob
            DocPrintJob job = printService.createPrintJob();

            // Create a Doc from the PDF file
            FileInputStream fis = new FileInputStream(filePath);
            Doc doc = new SimpleDoc(fis, flavor, null);

            // Print the document
            job.print(doc, pras);

            // Close the input stream
            fis.close();
        } catch (PrintException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







/*
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Printer {

    public static void printPdf (String path){
        String pdfFilePath = path;
       

        try {
            // Open the PDF file with the default PDF viewer
            Desktop desktop = Desktop.getDesktop();
            File file = new File(pdfFilePath);

            if (file.exists()) {
                desktop.print(file);
            } else {
                System.out.println("File not found: " + pdfFilePath);
            }

        } catch (IOException e) {
            System.out.println(e+"");
            JOptionPane.showMessageDialog(null, e+"");
        }
    }
}
*/