package controllers.afip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.w3c.dom.Document;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import play.Play;

public class AfipReporteController {

	public static void cxxx() {
		 try {

			 String dirTemp = System.getProperty("java.io.tmpdir");

		  // Source HTML file
		  String inputHTML = Play.application().getFile("conf/resources/reportes/recupero/factura.html").toString();
		  // Generated PDF file name
		  String outputPdf = dirTemp+"/Output.pdf";
		 // System.out.println(inputHTML);
		  String inputHTML2 = inputHTML.replace("pv", "00005");
		 // System.out.println(inputHTML2);


		  htmlToPdf(inputHTML2, outputPdf);


		} catch (IOException e) {
		  // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
	}

  private static Document html5ParseDocument(String inputHTML) throws IOException{

    org.jsoup.nodes.Document doc;
    System.out.println("parsing ...");

    doc = Jsoup.parse(new File(inputHTML), "UTF-8");




    org.jsoup.select.Elements myImgs = doc.select(".pv");

    for (org.jsoup.nodes.Element element : myImgs) {
    	element.text("00005");
    }









    System.out.println("parsing done ..."    );
    return new W3CDom().fromJsoup(doc);
	// return null;
  }

  private static void htmlToPdf(String inputHTML, String outputPdf) throws IOException {

	 Document doc = html5ParseDocument(inputHTML);

	 //doc = doc.getDocumentElement().toString().replace("pv", "00005");



    String dirTemp = System.getProperty("java.io.tmpdir");
    String baseUri = FileSystems.getDefault()
              .getPath(dirTemp+"/Output.pdf")
              .toUri()
              .toString();


    OutputStream os = new FileOutputStream(outputPdf);

    PdfRendererBuilder builder = new PdfRendererBuilder();
    builder.withUri(outputPdf);
    builder.toStream(os);
    // using absolute path here
    //builder.useFont(new File("F:\\knpcode\\Java\\Java Programs\\PDF using Java\\PDFBox\\Gabriola.ttf"),"Gabriola");
    builder.withW3cDocument(doc, baseUri);
    //builder.useUriResolver(new MyResolver());
    builder.run();

    System.out.println("PDF generation completed");
    os.close();
  }



}
