package controllers.firmaDigital;

import play.mvc.*;
import utils.firmadigital.PdfDigitalSignatureUtil;
import java.io.File;

public class PdfSignatureController extends Controller {

	/**
     * Firma un PDF con firma digital visible
     */
    public static Result signPdfDigital() {
        try {
            String srcPdf = "public/pdfs/documento.pdf";
            String destPdf = "public/pdfs/documento_firmado_digital.pdf";
            String keystorePath = "conf/certificado.p12";
            String keystorePassword = "tu_password";
            String alias = "tu_alias";

            // Firmar con firma visible en la esquina inferior derecha
            PdfDigitalSignatureUtil.signPdfVisible(
                srcPdf,
                destPdf,
                keystorePath,
                keystorePassword,
                alias,
                "Aprobado digitalmente",
                "Argentina",
                400,  // x
                50,   // y
                150,  // ancho
                75,   // alto
                1     // página
            );

            File signedFile = new File(destPdf);
            response().setContentType("application/pdf");
            response().setHeader("Content-Disposition",
                                "attachment; filename=documento_firmado_digital.pdf");

            return ok(signedFile);

        } catch (Exception e) {
            return internalServerError("Error al firmar digitalmente: " + e.getMessage());
        }
    }

    /**
     * Firma con imagen personalizada de firma
     */
    public static Result signPdfWithCustomImage() {
        try {
            String srcPdf = "public/pdfs/documento.pdf";
            String destPdf = "public/pdfs/documento_firmado_imagen.pdf";
            String keystorePath = "conf/certificado.p12";
            String keystorePassword = "tu_password";
            String alias = "tu_alias";
            String signatureImage = "public/images/firma.png";

            // Firma digital con imagen personalizada
            PdfDigitalSignatureUtil.signPdfWithImage(
                srcPdf,
                destPdf,
                keystorePath,
                keystorePassword,
                alias,
                "Documento aprobado",
                "Posadas, Misiones, Argentina",
                signatureImage,
                400, 50, 150, 75, 1
            );

            File signedFile = new File(destPdf);
            response().setContentType("application/pdf");
            response().setHeader("Content-Disposition",
                                "attachment; filename=documento_firmado.pdf");

            return ok(signedFile);

        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }

    /**
     * Firma invisible (sin apariencia visual)
     */
    public static Result signPdfInvisible() {
        try {
            String srcPdf = "public/pdfs/documento.pdf";
            String destPdf = "public/pdfs/documento_firmado_invisible.pdf";
            String keystorePath = "conf/certificado.p12";
            String keystorePassword = "tu_password";
            String alias = "tu_alias";

            PdfDigitalSignatureUtil.signPdfInvisible(
                srcPdf,
                destPdf,
                keystorePath,
                keystorePassword,
                alias,
                "Firma digital invisible",
                "Sistema"
            );

            return ok(new File(destPdf));

        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }

    /**
     * Verifica si un PDF tiene firmas digitales
     */
    public static Result verifyPdfSignature(String pdfPath) {
        try {
            boolean isSigned = PdfDigitalSignatureUtil.isPdfSigned(pdfPath);

            if (isSigned) {
                String info = PdfDigitalSignatureUtil.getSignatureInfo(pdfPath);
                return ok("PDF está firmado:\n" + info);
            } else {
                return ok("El PDF no tiene firmas digitales");
            }

        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }

    /**
     * Firma PDF subido por usuario
     */
    public static Result uploadAndSignDigital() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart pdfFile = body.getFile("pdf");

        if (pdfFile == null) {
            return badRequest("Falta el archivo PDF");
        }

        try {
            File uploadedFile = pdfFile.getFile();
            File signedFile = File.createTempFile("signed_digital_", ".pdf");

            String keystorePath = "conf/certificado.p12";
            String keystorePassword = "password";
            String alias = "mykey";

            // Obtener parámetros opcionales
            java.util.Map<String, String[]> formData = body.asFormUrlEncoded();
            String reason = formData.containsKey("reason") ?
                           formData.get("reason")[0] : "Documento firmado";
            String location = formData.containsKey("location") ?
                             formData.get("location")[0] : "Argentina";

            // Verificar si incluir imagen
            Http.MultipartFormData.FilePart signatureImage = body.getFile("signatureImage");

            if (signatureImage != null) {
                // Firma con imagen
                PdfDigitalSignatureUtil.signPdfWithImage(
                    uploadedFile.getAbsolutePath(),
                    signedFile.getAbsolutePath(),
                    keystorePath,
                    keystorePassword,
                    alias,
                    reason,
                    location,
                    signatureImage.getFile().getAbsolutePath(),
                    400, 50, 150, 75, 1
                );
            } else {
                // Firma sin imagen
                PdfDigitalSignatureUtil.signPdfVisible(
                    uploadedFile.getAbsolutePath(),
                    signedFile.getAbsolutePath(),
                    keystorePath,
                    keystorePassword,
                    alias,
                    reason,
                    location,
                    400, 50, 150, 75, 1
                );
            }

            response().setContentType("application/pdf");
            response().setHeader("Content-Disposition",
                               "attachment; filename=documento_firmado_digital.pdf");

            return ok(signedFile);

        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }

}
