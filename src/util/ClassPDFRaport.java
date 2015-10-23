/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author viorel.cojocaru
 */
public class ClassPDFRaport {

    private static BaseColor BORDO = new BaseColor(156, 33, 75);
    private static BaseColor SURIntunecat = new BaseColor(100, 100, 100);
    private static final Font font1 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, SURIntunecat);
    private static final Font font2 = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL, BaseColor.BLUE);
    private static final Font font3 = new Font(Font.FontFamily.HELVETICA, 20, Font.NORMAL, BORDO);
    private static final Font font4 = new Font(Font.FontFamily.COURIER, 12, Font.BOLD, BaseColor.RED);
    private static final Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLDITALIC, BaseColor.GREEN);
    private static final Font font6 = new Font(Font.FontFamily.TIMES_ROMAN, 40, Font.BOLDITALIC, BaseColor.LIGHT_GRAY);
    private static String[] nume = null;//Ion Ionescu", "Vasea Vasilescu", "Alina Alinescu", "Igor Igorescu", "Jora Jorescu
    private static String phrase = "That library was iText, and the book was titled iText in Action: Creating and Manipulating"
            + "PDF (2007). Today, iText is the world’s leading F/OSS PDF library. It’s"
            + "released under the Affero General Public License (AGPL) and is available in two"
            + "versions: the original Java version, and the C# port, iTextSharp. These libraries"
            + "make it possible for you to enhance applications with dynamic PDF solutions. You"
            + "can use iText to create invoices for your customers if you have a web shop, to produce"
            + "tickets if you work for an airline or railway company, and so on. You can integrate"
            + "iText into an application to generate PDF documents as an alternative to"
            + "printing on paper, to add digital signatures to a document, to split or concatenate different"
            + "documents, and so forth.";
    String fileName;

    public void createPDF() throws DocumentException, FileNotFoundException, BadElementException, MalformedURLException, IOException {
        alegeDestinatia();
        // -1- Cream un document iTextPDF
        Document document = new Document(PageSize.A4);
        //document.setMargins(70, 30, 50, 50);// setam marginile documentului, se refera la 

        // -2- Cream un flux de iesire in fisierul fileName, care ii il legam cu instanta lui PDFWriter

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));

        // -3- deschidem documentul cu open();
        document.open();


        // -4- AICI SE FAC TOATE OPERATIILE DE SCRIIRE IN FISIER


        //High Level Elements = CHUNK, PHRASE, PARAGRAPH, LIST, ANCHOR, CHAPTER etc le aranjezi prin metode
        //Low-Level Acces (writing to the direct content) scrierea desenarea pe layere, unde lingur deja trebuie sa aranjezi obiectele, cu ajutorul coordonatelor.

//        //Image imageJava = Image.getInstance("/home/iucosoft7/Nicolaev Maxim/DIPLOMA/DiplomaPDF-04.03/src/images/java.png");
//        Image imageJava = Image.getInstance("C:\\Users\\Mila\\Desktop\\Java Projects\\DemoPDF\\src\\images\\java.png");
//        imageJava.setAbsolutePosition((int)(document.getPageSize().getWidth()/2-imageJava.getWidth()/2*0.45), 0);  
//        imageJava.scalePercent(45f);
//        
//        //UNDER
//        PdfContentByte under = writer.getDirectContentUnder();

//        under.addImage(imageJava);

////        under.setColorFill(SURIntunecat);
////        under.rectangle(0, document.top() - 60, document.getPageSize().getWidth(), 100);
////        under.fill();

//////        under.setColorFill(BORDO);
//////        under.rectangle(0, document.top(), document.getPageSize().getWidth(), 60);
//////        under.fill();        


        //TITLE
        document.add(Chunk.NEWLINE.setLineHeight(10));
        document.add(new Chunk("FireScenne", font6));

        //PARAGRAPH        
        document.add(createTitle("Raport la scenele cautate"));

        //Numele COLEANE         
        String listaNumeColString = nume[0];
        document.add(new Chunk(listaNumeColString, font2));
        //
        Paragraph listaNume = createParagrafDinChunk();
        listaNume.setAlignment(0);//CENTER     paragraful are aliniere
        document.add(listaNume);




//        //PHRASE
//            document.add(createTitle("PHRASE"));
//        //document.add(Chunk.NEWLINE);        
//        //document.add(Chunk.NEXTPAGE);     trece pe alta pagina     
//        document.add(createPhrase());

//        //ANCHOR
//            document.add(createTitle("ANCHOR"));
//        //document.add(Chunk.NEWLINE);
//        document.add(createAnchor());

//         //LIST
//        document.add(createTitle("LIST"));
//        //document.add(Chunk.NEWLINE);
//        document.add(createList());

//            document.add(createTitle("PARAGRAPH cu alti parametri"));
//        Paragraph parDinPhrase=new Paragraph();       
//        parDinPhrase.setFirstLineIndent(20);
//        parDinPhrase.setLeading(15);
//        parDinPhrase.setFont(new Font(FontFamily.COURIER, 14, Font.ITALIC));
//        parDinPhrase.add(createPhrase());
//        document.add(parDinPhrase);

        //Pina aici se scrie in fisier


        //-5- inchidem documentul
        document.close();
    }

    private static Paragraph createParagrafDinChunk() {
        Paragraph paragraph = new Paragraph();
        for (String n : nume) {

            //CHUNK este ca STRING BUFFER / + Poti pune Font
            // paragraph.setFont(font1);
            paragraph.add(new Chunk(n));
            paragraph.add(new Chunk(" "));
            paragraph.add(Chunk.NEWLINE.setLineHeight(5));

        }
        return paragraph;
    }

    private static Phrase createPhrase() {
        Phrase phraseText = new Phrase();
        phraseText.setLeading(30);  // spatiu intre rinduri
        phraseText.setFont(font1);
        phraseText.add(phrase);

        return phraseText;
    }

    private static Anchor createAnchor() {
        Anchor anchor = new Anchor("http://itextpdf.com", font2);

        return anchor;
    }

    private static Paragraph createTitle(String titlu) {
        Paragraph paragraph = new Paragraph();
        paragraph.add(Chunk.NEWLINE.setLineHeight(20));
        paragraph.setFont(font3);
        paragraph.setAlignment(1);
        paragraph.add(new Chunk(titlu).setCharacterSpacing(3));
        return paragraph;
    }

    private static List createList() {
        List list = new List(true);
        for (String n : nume) {
            //CHUNK este ca STRING BUFFER / + Poti pune Font
            Chunk chunk = new Chunk(n);
            chunk.setFont(font5);
            ListItem listItem = new ListItem(chunk);
            listItem.setFont(font4);
            list.add(listItem);
        }
        return list;
    }

    public void introduVar(java.util.List<String> listaCuCheckBox) {
        int listCount = listaCuCheckBox.size();
        Iterator it = listaCuCheckBox.iterator();
        int i = 0;
        nume = new String[listCount];
        while (it.hasNext()) {
            nume[i] = (String) it.next();
            ++i;
        }
    }

    private void alegeDestinatia() {
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specifica numele fisirului");
        fileChooser.setSelectedFile(new File("Raport FireScenne.pdf"));
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            fileName = fileToSave.getAbsolutePath() + ".pdf";
        }
    }
}
