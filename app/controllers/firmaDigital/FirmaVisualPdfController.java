package controllers.firmaDigital;

import java.io.File;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import utils.firmadigital.PdfImageUtil;
import views.html.firmaDigital.*;
import play.mvc.*;
import java.io.FileInputStream;

public class FirmaVisualPdfController extends Controller {

	 public static Result index() {
		 return ok(mainFirmaDigital.render());
	 }

	/**
     * Inserta una firma predefinida en un PDF
     */
    public static Result addSignatureToPdf() {
        try {
            String srcPdf = "public/pdfs/documento.pdf";
            String destPdf = "public/pdfs/documento_firmado.pdf";
            String signatureImage = "public/images/firma.png";

            // Insertar firma en la esquina inferior derecha de la primera página
            // Coordenadas: x=400, y=50, tamaño: 150x75 pixeles
            PdfImageUtil.insertSignatureImage(
                srcPdf,
                destPdf,
                signatureImage,
                400,  // x
                50,   // y
                150,  // ancho
                75,   // alto
                1     // página
            );

            File signedFile = new File(destPdf);
            response().setContentType("application/pdf");
            response().setHeader("Content-Disposition",
                                "attachment; filename=documento_firmado.pdf");

            return ok(signedFile);

        } catch (Exception e) {
            return internalServerError("Error al insertar firma: " + e.getMessage());
        }
    }

    /**
     * Recibe un PDF y una imagen de firma, los combina y devuelve el resultado
     */
    public static Result uploadAndSign() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart pdfFile = body.getFile("pdf");
        Http.MultipartFormData.FilePart signatureFile = body.getFile("signature");

        if (pdfFile == null || signatureFile == null) {
            return badRequest("Se requieren archivo PDF y firma");
        }

        try {
            // Obtener archivos temporales
            File pdfTemp = pdfFile.getFile();
            File signatureTemp = signatureFile.getFile();
            File outputFile = File.createTempFile("signed_", ".pdf");

            // Obtener parámetros de posición desde el formulario
            Map<String, String[]> formData = body.asFormUrlEncoded();
            float x = Float.parseFloat(formData.get("x")[0]);
            float y = Float.parseFloat(formData.get("y")[0]);
            float width = Float.parseFloat(formData.get("width")[0]);
            float height = Float.parseFloat(formData.get("height")[0]);
            int page = Integer.parseInt(formData.get("page")[0]);

            // Insertar firma
            PdfImageUtil.insertSignatureImage(
                pdfTemp.getAbsolutePath(),
                outputFile.getAbsolutePath(),
                signatureTemp.getAbsolutePath(),
                x, y, width, height, page
            );

            response().setContentType("application/pdf");
            response().setHeader("Content-Disposition",
                               "attachment; filename=documento_firmado.pdf");

            return ok(outputFile);

        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }

    /**
     * Inserta firma con parámetros personalizados vía JSON
     */
    public static Result addSignatureWithParams() {
        try {
            // Leer parámetros del request JSON
            JsonNode json = request().body().asJson();

            String srcPdf = json.get("pdfPath").asText();
            String destPdf = json.get("outputPath").asText();
            String signatureImage = json.get("signaturePath").asText();
            float x = (float) json.get("x").asDouble();
            float y = (float) json.get("y").asDouble();
            float width = (float) json.get("width").asDouble();
            float height = (float) json.get("height").asDouble();
            int page = json.get("page").asInt();

            PdfImageUtil.insertSignatureImage(
                srcPdf, destPdf, signatureImage,
                x, y, width, height, page
            );

            return ok("Firma insertada exitosamente");

        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }

    /**
     * Agrega múltiples firmas a un PDF
     */
    public static Result addMultipleSignatures() {
        try {
            String srcPdf = "public/pdfs/contrato.pdf";
            String destPdf = "public/pdfs/contrato_firmado.pdf";

            // Definir posiciones para múltiples firmas
            PdfImageUtil.SignaturePosition[] signatures = {
                new PdfImageUtil.SignaturePosition(
                    "public/images/firma_cliente.png", 100, 100, 150, 75, 1
                ),
                new PdfImageUtil.SignaturePosition(
                    "public/images/firma_empresa.png", 350, 100, 150, 75, 1
                ),
                new PdfImageUtil.SignaturePosition(
                    "public/images/firma_testigo.png", 100, 50, 150, 75, 2
                )
            };

            PdfImageUtil.insertMultipleSignatures(srcPdf, destPdf, signatures);

            return ok(new File(destPdf));

        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }
}
