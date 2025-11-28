package utils.firmadigital;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PdfImageUtil {

	/**
     * Inserta una imagen (firma) en un PDF existente
     *
     * @param srcPdf Ruta del PDF original
     * @param destPdf Ruta del PDF con la firma insertada
     * @param imagePath Ruta de la imagen de la firma
     * @param x Coordenada X donde insertar la imagen
     * @param y Coordenada Y donde insertar la imagen
     * @param width Ancho de la imagen
     * @param height Alto de la imagen
     * @param page Número de página (1 es la primera)
     * @throws Exception
     */
    public static void insertSignatureImage(String srcPdf, String destPdf,
                                           String imagePath, float x, float y,
                                           float width, float height, int page)
                                           throws Exception {

        // Leer el PDF original
        PdfReader reader = new PdfReader(srcPdf);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));

        // Cargar la imagen
        Image image = Image.getInstance(imagePath);
        image.scaleAbsolute(width, height);
        image.setAbsolutePosition(x, y);

        // Obtener el contenido de la página
        PdfContentByte content = stamper.getOverContent(page);

        // Agregar la imagen
        content.addImage(image);

        // Cerrar recursos
        stamper.close();
        reader.close();
    }

    /**
     * Inserta una imagen desde un InputStream (útil para archivos subidos)
     */
    public static void insertSignatureImage(String srcPdf, String destPdf,
                                           InputStream imageStream, float x, float y,
                                           float width, float height, int page)
                                           throws Exception {

        PdfReader reader = new PdfReader(srcPdf);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));

        // Convertir InputStream a byte array
        byte[] imageBytes = inputStreamToByteArray(imageStream);

        // Cargar imagen desde byte array
        Image image = Image.getInstance(imageBytes);
        image.scaleAbsolute(width, height);
        image.setAbsolutePosition(x, y);

        PdfContentByte content = stamper.getOverContent(page);
        content.addImage(image);

        stamper.close();
        reader.close();
    }

    /**
     * Convierte un InputStream a byte array
     */
    private static byte[] inputStreamToByteArray(InputStream is) throws Exception {
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        return buffer.toByteArray();
    }

    /**
     * Inserta imagen con opacidad
     */
    public static void insertSignatureImageWithOpacity(String srcPdf, String destPdf,
                                                       String imagePath, float x, float y,
                                                       float width, float height,
                                                       int page, float opacity)
                                                       throws Exception {

        PdfReader reader = new PdfReader(srcPdf);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));

        Image image = Image.getInstance(imagePath);
        image.scaleAbsolute(width, height);
        image.setAbsolutePosition(x, y);

        // Aplicar opacidad (0.0 transparente - 1.0 opaco)
        PdfContentByte content = stamper.getOverContent(page);
        content.saveState();
        content.setGState(new com.itextpdf.text.pdf.PdfGState() {{
            setFillOpacity(opacity);
        }});
        content.addImage(image);
        content.restoreState();

        stamper.close();
        reader.close();
    }

    /**
     * Inserta múltiples firmas en diferentes posiciones
     */
    public static void insertMultipleSignatures(String srcPdf, String destPdf,
                                               SignaturePosition[] signatures)
                                               throws Exception {

        PdfReader reader = new PdfReader(srcPdf);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));

        for (SignaturePosition sig : signatures) {
            Image image = Image.getInstance(sig.imagePath);
            image.scaleAbsolute(sig.width, sig.height);
            image.setAbsolutePosition(sig.x, sig.y);

            PdfContentByte content = stamper.getOverContent(sig.page);
            content.addImage(image);
        }

        stamper.close();
        reader.close();
    }

    /**
     * Clase auxiliar para posición de firma
     */
    public static class SignaturePosition {
        public String imagePath;
        public float x, y, width, height;
        public int page;

        public SignaturePosition(String imagePath, float x, float y,
                               float width, float height, int page) {
            this.imagePath = imagePath;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.page = page;
        }
    }

    /**
     * Obtiene las dimensiones de una página del PDF
     */
    public static float[] getPageDimensions(String pdfPath, int page)
                                           throws Exception {
        PdfReader reader = new PdfReader(pdfPath);
        com.itextpdf.text.Rectangle pageSize = reader.getPageSize(page);
        float[] dimensions = {pageSize.getWidth(), pageSize.getHeight()};
        reader.close();
        return dimensions;
    }
}