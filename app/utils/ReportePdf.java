package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.w3c.dom.Document;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import play.Logger;
import play.Play;

public class ReportePdf {


	public static Document html5ParseDocumentPorElemento(String inputHTML,Map<String,String> datos) throws IOException,Exception{
		org.jsoup.nodes.Document doc;


	    doc = Jsoup.parse(new File(inputHTML), "UTF-8");

	    for (Map.Entry<String, String> entry : datos.entrySet()) {
	    	Logger.debug("xxxxxxx "+entry.getKey());
		    org.jsoup.select.Elements myImgs = doc.select("."+entry.getKey());

		    for (org.jsoup.nodes.Element element : myImgs) {
		    	//element.text(entry.getValue());

		    	element.append(entry.getValue());
		    }

	    }

	    return new W3CDom().fromJsoup(doc);
	}

	public static String reportePdfGenerico(String nameFile,Map<String,String> datos) throws IOException, Exception {
		String dirTemp = System.getProperty("java.io.tmpdir");

		 // Source HTML file
		 String inputHTML = Play.application().getFile("conf/resources/reportes/compras/reportePdf.html").toString();

		 String outputPdf = dirTemp+"/"+nameFile+".pdf";

		 Document doc = null;

		 doc = ReportePdf.html5ParseDocumentPorElemento(inputHTML, datos);//(inputHTML, outputPdf, id,"factura");

		 String baseUri = FileSystems.getDefault().getPath(dirTemp+"/"+nameFile+".pdf").toUri().toString();
		 OutputStream os = new FileOutputStream(outputPdf);

		 PdfRendererBuilder builder = new PdfRendererBuilder();
		 builder.withUri(outputPdf);
		 builder.toStream(os);
		 builder.withW3cDocument(doc, baseUri);
		 builder.run();
		 os.close();

		 return outputPdf;
	}

	public static String getFooterPage(int page,int qpage) {
		return "<div clase=\"footer-page\" style=\"\">\n" +
		 		"	<table style=\"width: 100%;    \">\n" +
		 		"	    <tbody>\n" +
		 		"		    <tr style=\" \">\n" +
		 		"				<td style=\"text-align: right;\">"+page+"/"+qpage+"</td>\n" +
		 		"			</tr>\n" +
		 		"		</tbody>\n" +
		 		"	</table>\n" +
		 		"</div>";
	}
}
