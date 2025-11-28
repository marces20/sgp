package utils.firmadigital;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.*;
import java.security.*;
import java.security.cert.Certificate;

public class PdfDigitalSignatureUtil {

	static {
        // Registrar el proveedor de seguridad BouncyCastle
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * Firma digitalmente un PDF con firma visible
     *
     * @param srcPdf Ruta del PDF original
     * @param destPdf Ruta del PDF firmado
     * @param keystorePath Ruta del keystore (.p12 o .pfx)
     * @param keystorePassword Password del keystore
     * @param alias Alias de la clave privada
     * @param reason Razón de la firma
     * @param location Ubicación de la firma
     * @param x Coordenada X
     * @param y Coordenada Y
     * @param width Ancho del cuadro de firma
     * @param height Alto del cuadro de firma
     * @param page Número de página
     */
    public static void signPdfVisible(String srcPdf, String destPdf,
                                     String keystorePath, String keystorePassword,
                                     String alias, String reason, String location,
                                     float x, float y, float width, float height,
                                     int page) throws Exception {

        // Cargar el keystore
        KeyStore ks = KeyStore.getInstance("PKCS12");
        FileInputStream fis = new FileInputStream(keystorePath);
        ks.load(fis, keystorePassword.toCharArray());
        fis.close();

        // Obtener la clave privada y el certificado
        PrivateKey pk = (PrivateKey) ks.getKey(alias, keystorePassword.toCharArray());
        Certificate[] chain = ks.getCertificateChain(alias);

        // Leer el PDF original
        PdfReader reader = new PdfReader(srcPdf);
        FileOutputStream os = new FileOutputStream(destPdf);

        // Crear el stamper en modo append
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0', null, true);

        // Configurar la apariencia de la firma
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason(reason);
        appearance.setLocation(location);
        appearance.setVisibleSignature(new Rectangle(x, y, x + width, y + height),
                                      page, "sig");

        // Crear la firma digital
        ExternalDigest digest = new BouncyCastleDigest();
        ExternalSignature signature = new PrivateKeySignature(pk,
                                        DigestAlgorithms.SHA256,
                                        BouncyCastleProvider.PROVIDER_NAME);

        // Firmar el documento
        MakeSignature.signDetached(appearance, digest, signature, chain,
                                   null, null, null, 0,
                                   MakeSignature.CryptoStandard.CMS);

        // Cerrar recursos
        stamper.close();
        reader.close();
        os.close();
    }

    /**
     * Firma digitalmente un PDF sin firma visible (invisible)
     */
    public static void signPdfInvisible(String srcPdf, String destPdf,
                                       String keystorePath, String keystorePassword,
                                       String alias, String reason, String location)
                                       throws Exception {

        KeyStore ks = KeyStore.getInstance("PKCS12");
        FileInputStream fis = new FileInputStream(keystorePath);
        ks.load(fis, keystorePassword.toCharArray());
        fis.close();

        PrivateKey pk = (PrivateKey) ks.getKey(alias, keystorePassword.toCharArray());
        Certificate[] chain = ks.getCertificateChain(alias);

        PdfReader reader = new PdfReader(srcPdf);
        FileOutputStream os = new FileOutputStream(destPdf);
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0', null, true);

        // Configurar firma invisible
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason(reason);
        appearance.setLocation(location);

        ExternalDigest digest = new BouncyCastleDigest();
        ExternalSignature signature = new PrivateKeySignature(pk,
                                        DigestAlgorithms.SHA256,
                                        BouncyCastleProvider.PROVIDER_NAME);

        MakeSignature.signDetached(appearance, digest, signature, chain,
                                   null, null, null, 0,
                                   MakeSignature.CryptoStandard.CMS);

        stamper.close();
        reader.close();
        os.close();
    }

    /**
     * Firma digitalmente con imagen personalizada
     */
    public static void signPdfWithImage(String srcPdf, String destPdf,
                                       String keystorePath, String keystorePassword,
                                       String alias, String reason, String location,
                                       String signatureImagePath,
                                       float x, float y, float width, float height,
                                       int page) throws Exception {

        KeyStore ks = KeyStore.getInstance("PKCS12");
        FileInputStream fis = new FileInputStream(keystorePath);
        ks.load(fis, keystorePassword.toCharArray());
        fis.close();

        PrivateKey pk = (PrivateKey) ks.getKey(alias, keystorePassword.toCharArray());
        Certificate[] chain = ks.getCertificateChain(alias);

        PdfReader reader = new PdfReader(srcPdf);
        FileOutputStream os = new FileOutputStream(destPdf);
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0', null, true);

        // Configurar apariencia con imagen
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason(reason);
        appearance.setLocation(location);
        appearance.setVisibleSignature(new Rectangle(x, y, x + width, y + height),
                                      page, "sig");

        // Agregar imagen de firma
        Image signatureImage = Image.getInstance(signatureImagePath);
        appearance.setSignatureGraphic(signatureImage);
        appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);

        ExternalDigest digest = new BouncyCastleDigest();
        ExternalSignature signature = new PrivateKeySignature(pk,
                                        DigestAlgorithms.SHA256,
                                        BouncyCastleProvider.PROVIDER_NAME);

        MakeSignature.signDetached(appearance, digest, signature, chain,
                                   null, null, null, 0,
                                   MakeSignature.CryptoStandard.CMS);

        stamper.close();
        reader.close();
        os.close();
    }

    /**
     * Firma con imagen y texto descriptivo
     */
    public static void signPdfWithImageAndText(String srcPdf, String destPdf,
                                              String keystorePath, String keystorePassword,
                                              String alias, String reason, String location,
                                              String signatureImagePath,
                                              float x, float y, float width, float height,
                                              int page) throws Exception {

        KeyStore ks = KeyStore.getInstance("PKCS12");
        FileInputStream fis = new FileInputStream(keystorePath);
        ks.load(fis, keystorePassword.toCharArray());
        fis.close();

        PrivateKey pk = (PrivateKey) ks.getKey(alias, keystorePassword.toCharArray());
        Certificate[] chain = ks.getCertificateChain(alias);

        PdfReader reader = new PdfReader(srcPdf);
        FileOutputStream os = new FileOutputStream(destPdf);
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0', null, true);

        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason(reason);
        appearance.setLocation(location);
        appearance.setVisibleSignature(new Rectangle(x, y, x + width, y + height),
                                      page, "sig");

        // Agregar imagen y mostrar descripción
        Image signatureImage = Image.getInstance(signatureImagePath);
        appearance.setSignatureGraphic(signatureImage);
        appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC_AND_DESCRIPTION);

        ExternalDigest digest = new BouncyCastleDigest();
        ExternalSignature signature = new PrivateKeySignature(pk,
                                        DigestAlgorithms.SHA256,
                                        BouncyCastleProvider.PROVIDER_NAME);

        MakeSignature.signDetached(appearance, digest, signature, chain,
                                   null, null, null, 0,
                                   MakeSignature.CryptoStandard.CMS);

        stamper.close();
        reader.close();
        os.close();
    }

    /**
     * Verifica si un PDF está firmado digitalmente
     */
    public static boolean isPdfSigned(String pdfPath) throws Exception {
        PdfReader reader = new PdfReader(pdfPath);
        com.itextpdf.text.pdf.AcroFields af = reader.getAcroFields();
        java.util.ArrayList<String> names = af.getSignatureNames();
        boolean isSigned = names.size() > 0;
        reader.close();
        return isSigned;
    }

    /**
     * Obtiene información de las firmas del PDF
     */
    public static String getSignatureInfo(String pdfPath) throws Exception {
        PdfReader reader = new PdfReader(pdfPath);
        com.itextpdf.text.pdf.AcroFields af = reader.getAcroFields();
        java.util.ArrayList<String> names = af.getSignatureNames();

        StringBuilder info = new StringBuilder();
        for (String name : names) {
            info.append("Firma: ").append(name).append("\n");
            PdfPKCS7 pk = af.verifySignature(name);
            info.append("Firmante: ").append(pk.getSignName()).append("\n");
            info.append("Fecha: ").append(pk.getSignDate().getTime()).append("\n");
            info.append("Razón: ").append(pk.getReason()).append("\n");
            info.append("Ubicación: ").append(pk.getLocation()).append("\n");
            info.append("---\n");
        }

        reader.close();
        return info.toString();
    }

}
