
package supermarketproject;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.xmp.options.AliasOptions;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author ANIS INFO
 */
public class PDFGenerator {
    public static void pdfCreate(String fileName, String date,String time) {
        String outputFolderPath = "Invoices";
        String outputFileName = fileName + ".pdf";

        // Create the output folder if it doesn't exist
        File outputFolder = new File(outputFolderPath);
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }

        // Create the full output path using File.separator
        String fullOutputPath = outputFolderPath + File.separator + outputFileName;

        Document document = new Document();

        try {
            
            PdfWriter.getInstance(document, new FileOutputStream(fullOutputPath));
            document.open();
           
            Paragraph header = new Paragraph("INVOICE\n\n\n",new Font(Font.FontFamily.HELVETICA,18,Font.BOLD));
            header.setAlignment(Element.ALIGN_CENTER);
            Paragraph d = new Paragraph("Date : "+date);
            Paragraph t = new Paragraph("Time : "+time+"\n\n");
            
             Font f0 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            PdfPTable table = new PdfPTable(3);
            table.addCell(new Phrase("Product",f0));
            table.addCell(new Phrase("Qte",f0));
            table.addCell(new Phrase("Sum",f0));

            switch(Lists.pointerOfList){
                case 1 -> {
                    for(Sale s: Lists.list1){
                        table.addCell(s.getProduct());
                        table.addCell(s.getQte()+"");
                        table.addCell(s.getSum()+"");
                    }
                }
                    
                case 2 -> {
                    for(Sale s: Lists.list1){
                        table.addCell(s.getProduct());
                        table.addCell(s.getQte()+"");
                        table.addCell(s.getSum()+"");
                    }
                    System.out.println("lsfkjmqkfjmqskjfmlqsjfmlqsjfmlqsjfmqsfqlmksjfqmsljfs");
                }
                
                default -> {
                    for(Sale s: Lists.list1){
                        table.addCell(s.getProduct());
                        table.addCell(s.getQte()+"");
                        table.addCell(s.getSum()+"");
                    }
                }
            }
 
            Paragraph pr = new Paragraph("\n********You're Welcome********", new Font(Font.FontFamily.COURIER,14,Font.BOLD));
            pr.setAlignment(Element.ALIGN_CENTER);
            
            document.add(header);
            document.add(d);
            document.add(t);
            document.add(table);
            document.add(pr);
        } catch (Exception e) {
            // Handle the exception properly, e.g., log the error or display a message
            System.out.println("Error creating PDF: " + e.getMessage());
        } finally {
            document.close();
        }
        Printer.printPDF(fullOutputPath);
    }
}
