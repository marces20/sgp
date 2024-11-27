package controllers.afip;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ParameterMode;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.Base64;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.mail.EmailException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;


import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.ClienteTipo;
import models.CondicionIva;
import models.Estado;
import models.Periodo;
import models.TipoComprobante;
import models.recupero.RecuperoAfipMovimiento;
import models.recupero.RecuperoFactura;
import models.recupero.RecuperoNotaCredito;
import models.recupero.RecuperoNotaDebito;
import play.Logger;
import play.Play;
import play.cache.Cache;
import utils.DateUtils;
import utils.EmailUtilis;
import utils.UriTrack;
import utils.afip.wsfe.wsdl.*;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import play.libs.Json;
import play.libs.WS;
import static play.libs.F.Function;
import static play.libs.F.Promise;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class AfipController {

	final static String SOAPHEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
			+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
			+ "<soap:Body>";

	final static String SOAPFOOTER = "</soap:Body></soap:Envelope>";


	public static String login() throws IOException, DatatypeConfigurationException, EmailException {

		///////////GENERACION P12//////////////
		// openssl genrsa -out privada 2048
		// el archvio  privada y PARQUESALUD_53794c62e26a1a54.crt  te lo tienen q pasar desde la afip para poder generar el .p12
		// openssl pkcs12 -export -inkey privada -in PARQUESALUD_53794c62e26a1a54.crt -name parquesalud -out PARQUESALUD_53794c62e26a1a54.p12
		//name es singer y el password lo q se genera



		String LoginTicketResponse = null;

		// Read config from phile
		Properties config = new Properties();

		String endpoint ="https://wsaa.afip.gov.ar/ws/services/LoginCms"; //config.getProperty("endpoint","http://wsaahomo.afip.gov.ar/ws/services/LoginCms");
		//wsdl_testing = 'https://wsaahomo.afip.gov.ar/ws/services/LoginCms?WSDL'
	    //wsdl_production = 'https://wsaa.afip.gov.ar/ws/services/LoginCms?WSDL'

		//String service = config.getProperty("service","test");
		String dstDN = "CN=wsaa, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239";//config.getProperty("dstdn","cn=wsaahomo,o=afip,c=ar,serialNumber=CUIT 33693450239");
		//TRA_DESTINATION_TESTING = "cn=wsaahomo,o=afip,c=ar,serialNumber=CUIT 33693450239"
		//TRA_DESTINATION_PRODUCTION = "cn=wsaa,o=afip,c=ar,serialNumber=CUIT 33693450239"

		//cn=srv1,ou=facturacion,o=empresa s.a.,c=ar,serialNumber=CUIT 30123456789

		//String p12file = config.getProperty("keystore","test-keystore.p12");
		//String signer = config.getProperty("keystore-signer","coqui");
		//String p12pass = config.getProperty("keystore-password","miclaveprivada");

		// Set proxy system vars
		//System.setProperty("http.proxyHost", config.getProperty("http_proxy",""));
		//System.setProperty("http.proxyPort", config.getProperty("http_proxy_port",""));
		//System.setProperty("http.proxyUser", config.getProperty("http_proxy_user",""));
		//System.setProperty("http.proxyPassword", config.getProperty("http_proxy_password",""));

		// Set the keystore used by SSL
		//System.setProperty("javax.net.ssl.trustStore", config.getProperty("trustStore",""));
		//System.setProperty("javax.net.ssl.trustStorePassword",config.getProperty("trustStore_password",""));

		Long TicketTime = new Long(config.getProperty("TicketTime","60"));

		// Create LoginTicketRequest_xml_cms

		InputStream in = Play.application().resourceAsStream("resources/PARQUESALUD_3b136ff81224f993.p12");

		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = null;
		if (play.Play.isProd()) {
			dirTemp ="/home/administrador/";
			archivo = new File(dirTemp+"/PARQUESALUD_3b136ff81224f993.p12");
			/*Files.copy(in, archivo.toPath(), StandardCopyOption.COPY_ATTRIBUTES.REPLACE_EXISTING);
			archivo.setExecutable(true);
			archivo.setReadable(true);
			archivo.setWritable(true);*/

		}else {
			archivo = new File(dirTemp+"/PARQUESALUD_3b136ff81224f993.p12");
			Files.copy(in, archivo.toPath(), StandardCopyOption.COPY_ATTRIBUTES.REPLACE_EXISTING);
			archivo.setExecutable(true);
			archivo.setReadable(true);
			archivo.setWritable(true);
		}


		byte [] LoginTicketRequest_xml_cms = create_cms(archivo.getAbsolutePath(), "parquesalud", "parquesalud", dstDN, "wsfe", new Long(28800000));

		//byte [] LoginTicketRequest_xml_cms = create_cms(p12file, p12pass, signer, dstDN, service, TicketTime);

		// Invoke AFIP wsaa and get LoginTicketResponse
		Logger.debug("endpoint "+endpoint);
		Logger.debug("LoginTicketRequest_xml_cms "+LoginTicketRequest_xml_cms);
		try {


			LoginTicketResponse = invoke_wsaa ( LoginTicketRequest_xml_cms, endpoint );


			System.out.println("xxxxxxxxxx: " + LoginTicketResponse);

		} catch (Exception e) {
			Cache.set("tokekafip",null);
			e.printStackTrace();
		}

		// Get token & sign from LoginTicketResponse
		try {
			Reader tokenReader = new StringReader(LoginTicketResponse);
			Document tokenDoc = new SAXReader(false).read(tokenReader);

			//System.out.println("tokenReader: " + tokenReader);
			//System.out.println("tokenDoc: " + tokenDoc);


			String token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
			String sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");

			//System.out.println("TOKEN: " + token);
			//System.out.println("SIGN: " + sign);

			Cache.set("tokekafip",token);
			Cache.set("singafip",sign);


		} catch (Exception e) {
			Cache.set("tokekafip",null);
			//System.out.println("tcaaaaaaaaaaaaaaaaaajetttttttttttttttttaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			System.out.println(e);
		}

		return "fin";
	}


	public static String invoke_wsaa (byte [] LoginTicketRequest_xml_cms, String endpoint) throws Exception {

		String LoginTicketResponse = null;
		try {

			Service service = new Service();
			Call call = (Call) service.createCall();

			//
			// Prepare the call for the Web service
			//
			call.setTargetEndpointAddress( new java.net.URL(endpoint) );
			call.setOperationName("loginCms");
			call.addParameter( "request", XMLType.XSD_STRING, ParameterMode.IN );
			call.setReturnType( XMLType.XSD_STRING );

			//
			// Make the actual call and assign the answer to a String
			//
			LoginTicketResponse = (String) call.invoke(new Object [] {
				Base64.encode (LoginTicketRequest_xml_cms) } );


		} catch (Exception e) {
			Cache.set("tokekafip",null);
			e.printStackTrace();
			Logger.debug("ExceptionExceptionExceptionExceptionExceptionException:  "+e);
			String errores = "ERROR LOGUEO AFIJ - invoke_wsaa "+e;
			RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, null,null,null,"ERROR",errores,new Date());
			ram.save();
			/*
			EmailUtilis eu = new EmailUtilis();
	        eu.setSubject("ERROR LOGUEO AFIJ invoke_wsaa");
	        eu.setHtmlMsg("Titulo: "+e);
	        eu.setFrom("marces2000@gmail.com");

	        List<String> adds = new ArrayList<>();
	        adds.add("marces2000@gmail.com");
	        eu.setAdds(adds);
	        eu.enviar();*/

		}

		return (LoginTicketResponse);
	}

	//
	// Create the CMS Message
	//
	public static byte [] create_cms (String p12file, String p12pass, String signer, String dstDN, String service, Long TicketTime) throws DatatypeConfigurationException, EmailException {
						 //create_cms(archivo.getAbsolutePath(), "parquesalud", "parquesalud", dstDN, "wsfe", new Long(36000));
		PrivateKey pKey = null;
		X509Certificate pCertificate = null;
		byte [] asn1_cms = null;
		CertStore cstore = null;
		String LoginTicketRequest_xml;
		String SignerDN = null;

		//
		// Manage Keys & Certificates
		//
		Logger.debug("aaaaaaaaaaa  ");
		try {
			// Create a keystore using keys from the pkcs#12 p12file
			KeyStore ks = KeyStore.getInstance("pkcs12");

			//Logger.debug("2222  "+p12file);

			FileInputStream p12stream = new FileInputStream ( p12file ) ;

			ks.load(p12stream, p12pass.toCharArray());
			p12stream.close();

			// Get Certificate & Private key from KeyStore
			pKey = (PrivateKey) ks.getKey(signer, p12pass.toCharArray());



			//Logger.debug("4444  "+ks.size());
			//Logger.debug("4444bbbbbbb  "+pKey);
			pCertificate = (X509Certificate)ks.getCertificate(signer);
			//Logger.debug("5555  "+pCertificate);
			SignerDN = pCertificate.getSubjectDN().toString();

			// Create a list of Certificates to include in the final CMS
			ArrayList<X509Certificate> certList = new ArrayList<X509Certificate>();
			certList.add(pCertificate);

			if (Security.getProvider("BC") == null) {
				Security.addProvider(new BouncyCastleProvider());
			}

			cstore = CertStore.getInstance("Collection", new CollectionCertStoreParameters (certList), "BC");
		}
		catch (Exception e) {
			Logger.debug("xxxxxxxxxxxxx77  "+e);
			Cache.set("tokekafip",null);
			e.printStackTrace();
			String errores = "ERROR LOGUEO AFIJ 1- create_cms "+e;
			RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, null,null,null,"ERROR",errores,new Date());
			ram.save();

			/*
			EmailUtilis eu = new EmailUtilis();
	        eu.setSubject("ERROR LOGUEO AFIJ 1- create_cms ");
	        eu.setHtmlMsg("Titulo: "+e);
	        eu.setFrom("marces2000@gmail.com");

	        List<String> adds = new ArrayList<>();
	        adds.add("marces2000@gmail.com");
	        eu.setAdds(adds);
	        eu.enviar();*/

		}
		Logger.debug("xxxxxxxxxxxxxffff  ");
		//
		// Create XML Message
		//
		LoginTicketRequest_xml = null;
		try {

			LoginTicketRequest_xml = create_LoginTicketRequest(SignerDN, dstDN, service, TicketTime);

		}catch (Exception e) {
			Logger.debug("xxxxxxxxxxxxx88  "+e);
			Cache.set("tokekafip",null);
			e.printStackTrace();
			String errores = "ERROR LOGUEO AFIJ 2- create_cms "+e;
			RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, null,null,null,"ERROR",errores,new Date());
			ram.save();
			/*EmailUtilis eu = new EmailUtilis();
	        eu.setSubject("ERROR LOGUEO AFIJ 2- create_cms ");
	        eu.setHtmlMsg("Titulo: "+e);
	        eu.setFrom("marces2000@gmail.com");

	        List<String> adds = new ArrayList<>();
	        adds.add("marces2000@gmail.com");
	        eu.setAdds(adds);
	        eu.enviar();*/
		}

		//
		// Create CMS Message
		//
		try {
			// Create a new empty CMS Message
			CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

			// Add a Signer to the Message
			gen.addSigner(pKey, pCertificate, CMSSignedDataGenerator.DIGEST_SHA1);

			// Add the Certificate to the Message
      		gen.addCertificatesAndCRLs(cstore);

			// Add the data (XML) to the Message
			CMSProcessable data = new CMSProcessableByteArray(LoginTicketRequest_xml.getBytes());

			// Add a Sign of the Data to the Message
			CMSSignedData signed = gen.generate(data, true, "BC");

			//
			asn1_cms = signed.getEncoded();
		}
		catch (Exception e) {
			e.printStackTrace();
			Cache.set("tokekafip",null);
			String errores = "ERROR LOGUEO AFIJ 3- create_cms "+e;
			RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, null,null,null,"ERROR",errores,new Date());
			ram.save();
			/*EmailUtilis eu = new EmailUtilis();
	        eu.setSubject("ERROR LOGUEO AFIJ 3- create_cms ");
	        eu.setHtmlMsg("Titulo: "+e);
	        eu.setFrom("marces2000@gmail.com");

	        List<String> adds = new ArrayList<>();
	        adds.add("marces2000@gmail.com");
	        eu.setAdds(adds);
	        eu.enviar();*/
		}

		return (asn1_cms);
	}

	//
	// Create XML Message for AFIP wsaa
	//
	public static String create_LoginTicketRequest (String SignerDN, String dstDN, String service, Long TicketTime) throws DatatypeConfigurationException {

		String LoginTicketRequest_xml;

		Date GenTime = new Date();
		GregorianCalendar gentime = new GregorianCalendar();
		GregorianCalendar exptime = new GregorianCalendar();
		String UniqueId = new Long(GenTime.getTime() / 1000).toString();

		Date ex = new Date(GenTime.getTime()+TicketTime);
		Cache.set("exptime", ex);

		exptime.setTime(ex);

		//XMLGregorianCalendarImpl XMLGenTime = new XMLGregorianCalendarImpl(gentime);
		//XMLGregorianCalendarImpl XMLExpTime = new XMLGregorianCalendarImpl(exptime);
		XMLGregorianCalendar XMLGenTime = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(gentime);
		XMLGregorianCalendar XMLExpTime = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(exptime);

		System.out.println("XMLGenTime: " + XMLGenTime);
		System.out.println("XMLExpTime: " + XMLExpTime);
		System.out.println("exptime: " + Cache.get("exptime"));

		LoginTicketRequest_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
						+"<loginTicketRequest version=\"1.0\">"
			+"<header>"
			+"<source>" + SignerDN + "</source>"
			+"<destination>" + dstDN + "</destination>"
			+"<uniqueId>" + UniqueId + "</uniqueId>"
			+"<generationTime>" + XMLGenTime + "</generationTime>"
			+"<expirationTime>" + XMLExpTime + "</expirationTime>"
			+"</header>"
			+"<service>" + service + "</service>"
			+"</loginTicketRequest>";

		System.out.println("TRA: " + LoginTicketRequest_xml);

		return (LoginTicketRequest_xml);
	}

	public FEAuthRequest getAuth() throws IOException, DatatypeConfigurationException, EmailException {


		FEAuthRequest auth = null;

		Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1 ");
		Logger.debug("Cache.get(\"tokekafip\") "+Cache.get("tokekafip"));
		Logger.debug("Cache.get(\"singafip\") "+Cache.get("singafip"));
		Logger.debug("Cache.get(\"exptime\") "+Cache.get("exptime"));

		if(Cache.get("tokekafip") == null || Cache.get("singafip") == null) {
			Logger.debug("xxxxxxxxxxxxx1 ");
			login();
		}else if(Cache.get("exptime") != null) {
			Logger.debug("xxxxxxxxxxxxx2 ");
			Date ex = (Date) Cache.get("exptime");
			Date now = new Date();
			Logger.debug(" Cache.get  "+Cache.get("exptime"));
			Logger.debug("NOW  "+now);

			if(ex.compareTo(now) <= 0) {
				Logger.debug("SEEE EXPIROO EL TOKEN  ");
				login();
			}
		}else {
			Logger.debug("xxxxxxxxxxxxx3 ");
			login();
		}

		//login();
		Logger.debug("xxxxxxxxxxxxx4 ");

		auth = new FEAuthRequest();
		auth.setCuit(Long.parseLong("30712224300"));
		auth.setToken(Cache.get("tokekafip").toString());
		auth.setSign(Cache.get("singafip").toString());

		return auth;

	}

	public ObjectNode getUltimoComprobanteNew( int puntoVenta, int tipoComprobante) throws JAXBException, SOAPException, ParserConfigurationException,  IOException, XMLStreamException, SAXException, XPathExpressionException, TransformerException, EmailException{

		int result = -1;
		ObjectNode restJs = Json.newObject();
		restJs.put("success", false);
		restJs.put("error", "");
		restJs.put("data", "");

		FEAuthRequest auth = null;

		try {

			auth  = getAuth();

		}catch (Exception e) {
			// TODO: handle exception
			Cache.set("tokekafip",null);
		}


		try {

			/*FEAuthRequest auth = new FEAuthRequest();
			auth.setCuit(Long.parseLong("30712224300"));
			auth.setToken(Cache.get("tokekafip").toString());
			auth.setSign(Cache.get("singafip").toString());*/

			System.out.println("-----------getFECompUltimoAutorizadoResult authauthauth-------------"+auth.toString());

			FECompUltimoAutorizado request = new FECompUltimoAutorizado();
			request.setAuth(auth);
			request.setCbteTipo(tipoComprobante);
			request.setPtoVta(puntoVenta);

			JAXBContext contexto = JAXBContext.newInstance(request.getClass());
	        Marshaller marshaller = contexto.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

	        StringWriter sw = new StringWriter();
	        marshaller.marshal(request, sw);

			String sw1 = sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
	        String sopa = SOAPHEADER+sw1+SOAPFOOTER;
	        Promise<WS.Response> result2 = WS.url("https://servicios1.afip.gov.ar/wsfev1/service.asmx").setContentType("text/xml").post(sopa);
	        InputStream targetStream = new ByteArrayInputStream(result2.get().getBody().getBytes());

	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        org.w3c.dom.Document doc = dbf.newDocumentBuilder().parse(targetStream);

	        XPath xPath = XPathFactory.newInstance().newXPath();
	        Node result3 = (Node)xPath.evaluate("//FECompUltimoAutorizadoResponse", doc, XPathConstants.NODE);


	        JAXBContext jaxbContext = JAXBContext.newInstance(FECompUltimoAutorizadoResponse.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

	        StringReader finalreader = new StringReader(nodeToString(result3));
	        FECompUltimoAutorizadoResponse datos = (FECompUltimoAutorizadoResponse) jaxbUnmarshaller.unmarshal(finalreader);

	        System.out.println("-----------getFECompUltimoAutorizadoResult-------------");
	        System.out.println(datos.getFECompUltimoAutorizadoResult());
	        System.out.println(datos.getFECompUltimoAutorizadoResult().getCbteTipo());
	        System.out.println("getCbteNro: "+datos.getFECompUltimoAutorizadoResult().getCbteNro());
	        System.out.println(datos.getFECompUltimoAutorizadoResult().getPtoVta());
	        System.out.println("-----------------------------------");
	        System.out.println("Valor: "+datos.getFECompUltimoAutorizadoResult().getErrors());

	        boolean erro = false;
	        if(datos.getFECompUltimoAutorizadoResult().getErrors() != null) {
	        	String errores = "";
		        for(Err a : datos.getFECompUltimoAutorizadoResult().getErrors().getErr()) {
		        	errores += a.getMsg()+" - ";
		        	System.out.println("a.getMsg();: "+a.getMsg());
		        }


				RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, null,null,null,"ERROR","getUltimoComprobanteNew: "+errores,new Date());
				ram.save();

		        /*EmailUtilis eu = new EmailUtilis();
		        eu.setSubject("ERROR AFIJ getUltimoComprobanteNew ");
		        eu.setHtmlMsg("Titulo errores: "+errores);
		        eu.setFrom("marces2000@gmail.com");

		        List<String> adds = new ArrayList<>();
		        adds.add("marces2000@gmail.com");
		        eu.setAdds(adds);
		        eu.enviar();*/


		        restJs.put("error", errores);
		        //throw new Exception();
	        }



	        Logger.debug("getUltimoComprobanteNew pasa");
	        restJs.put("data", datos.getFECompUltimoAutorizadoResult().getCbteNro());
	        restJs.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			Cache.set("tokekafip",null);
			Logger.debug("errorrrr ennn GETT ULTIMO COMPROBANTEEEEE");

			String errores = "ERROR LOGUEO AFIJ - getUltimoComprobanteNew "+e;
			RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, null,null,null,"ERROR",errores,new Date());
			ram.save();

			/*EmailUtilis eu = new EmailUtilis();
	        eu.setSubject("ERROR AFIJ getUltimoComprobanteNew ");
	        eu.setHtmlMsg("Titulo: "+e);
	        eu.setFrom("marces2000@gmail.com");

	        List<String> adds = new ArrayList<>();
	        adds.add("marces2000@gmail.com");
	        eu.setAdds(adds);
	        eu.enviar();*/
		}



		return restJs;
	}

	public ObjectNode setComprobante(Long  id,int cbteTipo) {
		int result = -1;

		ObjectNode restJs = Json.newObject();
		restJs.put("success", false);
		restJs.put("error", "");
		restJs.put("data", "");

		FEAuthRequest auth = null;

		try {

			auth  = getAuth();

		}catch (Exception e) {
			Logger.debug("errro setComprobante 1 "+e);
			Cache.set("tokekafip",null);
		}

		try {

			Logger.debug("errro setComprobante 111111111111111111111111111111111 ");

			Long idFactura = null;
			double importe = 0;
			String fecha = null;
			models.Periodo periodo = null;
			String fechaDesde = null;
			String fechaHasta = null;
			RecuperoNotaDebito rd = null;
			RecuperoNotaCredito rc = null;
			Integer ptoVta = null;
			String cae = "";


			if(cbteTipo == TipoComprobante.NOTA_CREDITO) {
				System.out.println("==========NOTAAA CREDITOO==================");
				rc = RecuperoNotaCredito.find.byId(id);
				importe = rc.getTotal().doubleValue();
				idFactura = rc.recupero_factura_id;
				fecha = DateUtils.formatDate(rc.fecha,"yyyyMMdd");
				periodo = Periodo.getPeriodoByDate(rc.fecha);//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
				fechaDesde = DateUtils.formatDate(periodo.date_start,"yyyyMMdd");
				fechaHasta = DateUtils.formatDate(periodo.date_stop,"yyyyMMdd");
				ptoVta = new Integer(rc.puntoVenta.numero);
			}else if(cbteTipo == TipoComprobante.NOTA_DEBITO) {
				System.out.println("==========NOTAAA DEBITOO==================");
				rd = RecuperoNotaDebito.find.byId(id);
				importe = rd.getTotal().doubleValue();
				idFactura = rd.recupero_factura_id;
				fecha = DateUtils.formatDate(rd.fecha,"yyyyMMdd");
				periodo = Periodo.getPeriodoByDate(rd.fecha);//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
				fechaDesde = DateUtils.formatDate(periodo.date_start,"yyyyMMdd");
				fechaHasta = DateUtils.formatDate(periodo.date_stop,"yyyyMMdd");
				ptoVta = new Integer(rd.puntoVenta.numero);
			}else {
				idFactura = id;
			}


			RecuperoFactura rf = RecuperoFactura.find.byId(idFactura);
			Logger.debug("==============CAAAAAAAAAEEEEEEEEEEEEE222=============000000 "+rf.numero );


			if(cbteTipo == TipoComprobante.FACTURA) {
				System.out.println("==========NOTAAA FACTURAAA==================");
				importe = rf.getBase().doubleValue();
				fecha = DateUtils.formatDate(rf.fecha,"yyyyMMdd");
				periodo = Periodo.getPeriodoByDate(rf.fecha);//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
				if(rf.fecha_desde != null && rf.fecha_hasta != null) {
					fechaDesde = DateUtils.formatDate(rf.fecha_desde,"yyyyMMdd");
					fechaHasta = DateUtils.formatDate(rf.fecha_hasta,"yyyyMMdd");
				}else {
					fechaDesde = DateUtils.formatDate(periodo.date_start,"yyyyMMdd");
					fechaHasta = DateUtils.formatDate(periodo.date_stop,"yyyyMMdd");
				}
				ptoVta = new Integer(rf.puntoVenta.numero);
			}


			Logger.debug("==============CAAAAAAAAAEEEEEEEEEEEEE222=============01111 "+rf.numero );


			if(rf != null) {

				Logger.debug("errro setComprobante 22222222222222222 ");

				int docTipo = 80;
				Long doc = null;

				if(rf.cliente.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS) == 0 || rf.cliente.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS_SIN_RESIDENCIA) == 0) {
					docTipo = 91;
				}



				if(rf.cliente.cie != null && !rf.cliente.cie.isEmpty()) {
					doc = new Long(rf.cliente.cie);
					docTipo = 91;
				}else if(rf.cliente.cuit2 != null && !rf.cliente.cuit2.isEmpty()) {
					doc = new Long(rf.cliente.cuit2);
				}else if(rf.cliente.dni != null) {
					doc = new Long(rf.cliente.dni);
					docTipo = 96;
				}

				if(rf.cliente.cliente_tipo_id.compareTo(ClienteTipo.ART) == 0 || rf.cliente.cliente_tipo_id.compareTo(ClienteTipo.SEGUROS) == 0 || rf.cliente.cliente_tipo_id.compareTo(ClienteTipo.OBRAS_SOCIALES) == 0) {
					if(rf.cliente.condicioniva_id.compareTo(CondicionIva.CLIENTE_EXTERIOR.intValue()) == 0) {
						docTipo = 91;
					}
				}



				Logger.debug("==============CAAAAAAAAAEEEEEEEEEEEEE222=============022222 "+rf.numero );


				System.out.println("==============err===============================");

				System.out.println(ptoVta);
				System.out.println(docTipo);
				System.out.println(doc);
	            System.out.println(fecha);
	            System.out.println(fechaDesde);
	            System.out.println(fechaHasta);
	            System.out.println("==============================================================");

				if(doc != null) {


					FECAESolicitar fECAESolicitar = new FECAESolicitar();
			        fECAESolicitar.setAuth(auth);

					AfipController a = new AfipController();
					ObjectNode cc = a.getUltimoComprobanteNew(ptoVta,cbteTipo);
					Long CbteNro = null;
					System.out.println("===============22222222222222222222cc.get(\"error\") ======================");
					if(cc.get("error") != null && !cc.get("error").asText().isEmpty() ) {

						System.out.println("===============22222222222222222222cc.get(\"error\") ======================"+cc.get("error"));

						restJs.put("error", cc.get("error"));
						return restJs;
					}


					if(cc.get("success").asText().compareTo("true") == 0) {
						Logger.debug("==============CbteNro===============22222222222222==========");
						JAXBContext jaxbContext = JAXBContext.newInstance(FECompUltimoAutorizadoResponse.class);
				        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
						StringReader finalreader = new StringReader(cc.get("data").asText());

						CbteNro = new Long(cc.get("data").asText())+1;
					}

					Logger.debug("==============CbteNro===============================");
					Logger.debug(CbteNro.toString());
					Logger.debug("==============CbteNro===============================");



			        /************SET CAB REQ***********************/
			        /*
			         * 	<ar:FeCabReq>
						 <ar:CantReg>int</ar:CantReg>
						 <ar:PtoVta>int</ar:PtoVta>
						 <ar:CbteTipo>int</ar:CbteTipo>
						</ar:FeCabReq>
			         */
					FECAERequest fcaer = new FECAERequest();

			        FECAECabRequest fECAECabRequest = new FECAECabRequest();
			        fECAECabRequest.setCantReg(1);
			        fECAECabRequest.setCbteTipo(cbteTipo);
			        fECAECabRequest.setPtoVta(ptoVta);

			        fcaer.setFeCabReq(fECAECabRequest);
			        /************FIN SET CAB REQ***********************/


			        /************SET DETALLE CAE***********************/

					FECAEDetRequest fECAEDetRequest = new FECAEDetRequest();
			        fECAEDetRequest.setConcepto(3);//<ar:Concepto>int</ar:Concepto>

			        fECAEDetRequest.setDocTipo(docTipo);//<ar:DocTipo>int</ar:DocTipo>
			        fECAEDetRequest.setDocNro(doc);//<ar:DocNro>long</ar:DocNro>

			        fECAEDetRequest.setCbteDesde(CbteNro);//<ar:CbteDesde>long</ar:CbteDesde>
			        fECAEDetRequest.setCbteHasta(CbteNro);//<ar:CbteHasta>long</ar:CbteHasta>

			        fECAEDetRequest.setCbteFch(fecha);//<ar:CbteFch>string</ar:CbteFch>

			        fECAEDetRequest.setFchServDesde(fechaDesde);
			        fECAEDetRequest.setFchServHasta(fechaHasta);
			        fECAEDetRequest.setFchVtoPago(fecha);

			        fECAEDetRequest.setImpTotal(importe);//<ar:ImpTotal>double</ar:ImpTotal>
			        fECAEDetRequest.setImpTotConc(0);//<ar:ImpTotConc>double</ar:ImpTotConc>
			        fECAEDetRequest.setImpNeto(importe);//<ar:ImpNeto>double</ar:ImpNeto>
			        fECAEDetRequest.setImpOpEx(0);//<ar:ImpOpEx>double</ar:ImpOpEx>
			        fECAEDetRequest.setImpTrib(0);//<ar:ImpTrib>double</ar:ImpTrib>
			        fECAEDetRequest.setImpIVA(0);//<ar:ImpIVA>double</ar:ImpIVA>

			        fECAEDetRequest.setMonId("PES");//<ar:MonId>string</ar:MonId>
			        fECAEDetRequest.setMonCotiz(1);//<ar:MonCotiz>double</ar:MonCotiz>
			        //fECAEDetRequest.setFchServDesde(value);//<ar:FchServDesde>string</ar:FchServDesde>
			        //fECAEDetRequest.setFchServHasta(value);//<ar:FchServHasta>string</ar:FchServHasta>
			        //fECAEDetRequest.setFchVtoPago(value);//<ar:FchVtoPago>string</ar:FchVtoPago>

			        ArrayOfCbteAsoc cbteAsocArray = new ArrayOfCbteAsoc();

			        System.out.println(ptoVta);
					System.out.println(docTipo);
					System.out.println(doc);

					if(cbteTipo == TipoComprobante.NOTA_CREDITO || cbteTipo == TipoComprobante.NOTA_DEBITO) {
				        CbteAsoc cbteAsoc = new CbteAsoc();
				        cbteAsoc.setPtoVta(new Integer(rf.puntoVenta.numero));
				        cbteAsoc.setNro(new Integer(rf.numero));
				        cbteAsoc.setTipo(TipoComprobante.FACTURA);
				        //cbteAsoc.setCuit(value);
				        //cbteAsoc.setCbteFch(value);
				        cbteAsocArray.getCbteAsoc().add(cbteAsoc);
				        fECAEDetRequest.setCbtesAsoc(cbteAsocArray);
					}

			        //.getMsg();: El campo  'Importe Total' ImpTotal, debe ser igual  a la  suma de ImpTotConc + ImpNeto + ImpOpEx + ImpTrib + ImpIVA.
			        //a.getMsg();: Si ImpNeto es mayor a 0 el objeto IVA es obligatorio.
			        //a.getMsg();: Si el comprobante es Debito o Credito, enviar estructura CbteAsoc o PeriodoAsoc.


			        ArrayOfFECAEDetRequest arrayOfFECAEDetRequest = new ArrayOfFECAEDetRequest();
			        List<FECAEDetRequest> fecaeDetRequests = arrayOfFECAEDetRequest.getFECAEDetRequest();
			        fecaeDetRequests.add(fECAEDetRequest);
			        fcaer.setFeDetReq(arrayOfFECAEDetRequest);

			        /************FIN SET DETALLE CAE***********************/

			        fECAESolicitar.setFeCAEReq(fcaer);



			        Logger.debug("==============CAAAAAAAAAEEEEEEEEEEEEE222=============03333 "+rf.numero );




			        JAXBContext contexto2 = JAXBContext.newInstance(fECAESolicitar.getClass());
			        Marshaller marshaller2 = contexto2.createMarshaller();
			        marshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			        StringWriter sw2 = new StringWriter();
			        marshaller2.marshal(fECAESolicitar, sw2);

			        String sw12 = sw2.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
			        String sopa = SOAPHEADER+sw12+SOAPFOOTER;
			        Promise<WS.Response> result222 = WS.url("https://servicios1.afip.gov.ar/wsfev1/service.asmx").setContentType("text/xml").post(sopa);
					InputStream targetStream2 = new ByteArrayInputStream(result222.get().getBody().getBytes());

					Logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz ");
			        Logger.debug("result32result32result32result32result32 "+result222.get().getBody());

			        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
			        org.w3c.dom.Document doc2 = dbf2.newDocumentBuilder().parse(targetStream2);

			        XPath xPath2 = XPathFactory.newInstance().newXPath();
			        Node result32 = (Node)xPath2.evaluate("//FECAESolicitarResponse", doc2, XPathConstants.NODE);


			        StringReader finalreader2 = new StringReader(nodeToString(result32));
			        System.out.println(finalreader2);
			        Logger.debug("finalreader2finalreader2finalreader2 "+finalreader2);
					/////////////////////////////

			        JAXBContext jaxbContext2 = JAXBContext.newInstance(FECAESolicitarResponse.class);
			        Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();

			        FECAESolicitarResponse datos2 = (FECAESolicitarResponse) jaxbUnmarshaller2.unmarshal(finalreader2);
			        Logger.debug("==============CAAAAAAAAAEEEEEEEEEEEEE222=============055555 "+rf.numero );
			        if(datos2.getFECAESolicitarResult().getErrors() != null) {
		            	String errores = "";
		    	        for(Err ax : datos2.getFECAESolicitarResult().getErrors().getErr()) {
		    	        	errores += ax.getMsg()+" - ";
		    	        	Logger.debug("eeeeeeeerrrrrrrrrrrrroooooooo a.getMsg();: "+ax.getMsg());
				        }
				        restJs.put("error", errores);
				        RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,idFactura.intValue(),null, null,cbteTipo,null,"ERROR",errores,new Date());
						ram.save();

		            }else {

 		            	boolean er= false;

				        for(FECAEDetResponse xx : datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse()) {

				        	Logger.debug("==============CAAAAAAAAAEEEEEEEEEEEEE111============= "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse());


				        	if(xx.getCAE() != null && !xx.getCAE().isEmpty()) {

				        		cae = xx.getCAE() ;
				        		if(cbteTipo == TipoComprobante.NOTA_CREDITO) {
				        			rc.cae = xx.getCAE();
				    				rc.numero = utils.NumberUtils.agregarCerosAlaIzquierda(CbteNro.intValue(), 8);
				    				rc.fecha_vencimiento =utils.DateUtils.formatDate(xx.getCAEFchVto(), "yyyyMMdd");
				    				rc.save();

				    			}else if(cbteTipo == TipoComprobante.NOTA_DEBITO) {
				    				rd.cae = xx.getCAE();
				    				rd.numero = utils.NumberUtils.agregarCerosAlaIzquierda(CbteNro.intValue(), 8);
				    				rd.fecha_vencimiento =utils.DateUtils.formatDate(xx.getCAEFchVto(), "yyyyMMdd");
				    				rd.save();

				    			}else {
				    				rf.cae = xx.getCAE();
					        		rf.numero = utils.NumberUtils.agregarCerosAlaIzquierda(CbteNro.intValue(), 8);
					        		rf.fecha_vencimiento =utils.DateUtils.formatDate(xx.getCAEFchVto(), "yyyyMMdd");
					        		rf.save();
				    			}

				        	}else {
				        		 String Msg= "";
				        		 for(Obs obs : xx.getObservaciones().getObs()) {
				        			 Msg += obs.getMsg();
				        		 }
				        		 restJs.put("error", Msg);
				        		 er= true;

				        		RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,idFactura.intValue(),null, null,cbteTipo,null,"ERROR",Msg,new Date());
								ram.save();
				        	}

				        }
				        if(!er) {
				        	restJs.put("data", datos2.toString());
					        restJs.put("cae", cae);
					        restJs.put("success", true);
				        }
 				        Logger.debug("datos2datos2datos2datos2datos2 "+datos2.toString());
				        Logger.debug("setComprobante pasa");

		            }



				}



			}

		}catch (Exception e) {
			Logger.debug("errro setComprobante 333333333333333333333333333333333333 "+e);
			Cache.set("tokekafip",null);
		}

		Logger.debug("termina setComprobante 4444444444444444444444444444444444 "+restJs.toString());


		return restJs;
	}

	private static String nodeToString(Node node) throws TransformerException{
	    StringWriter buf = new StringWriter();
	    Transformer xform = TransformerFactory.newInstance().newTransformer();
	    xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	    xform.transform(new DOMSource(node), new StreamResult(buf));
	    return(buf.toString());
	}


	//public int getUltimoComprobante(TRA tra, int puntoVenta, int tipoComprobante){
	public int getUltimoComprobante( int puntoVenta, int tipoComprobante) throws JAXBException, SOAPException, ParserConfigurationException,  IOException, XMLStreamException, SAXException, XPathExpressionException, TransformerException{

		int result = -1;

		//WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		//webServiceTemplate.setDefaultUri(tra.getTargetServiceUrl());
		//webServiceTemplate.setDefaultUri("https://wswhomo.afip.gov.ar/wsfev1/service.asmx");

		//Create request and params, including Auth
		FEAuthRequest auth = new FEAuthRequest();
		auth.setCuit(Long.parseLong("30712224300"));
		auth.setToken("");
		auth.setSign("");
		//auth.setCuit(Long.parseLong(tra.getCuit()));
		//auth.setToken(tra.getToken());
		//auth.setSign(tra.getSign());

		FECompUltimoAutorizado request = new FECompUltimoAutorizado();
		request.setAuth(auth);
		request.setCbteTipo(tipoComprobante);
		request.setPtoVta(puntoVenta);

		//Logger.debug("xxxxxxxxxxx");
		//Logger.debug(" "+request);
		//Logger.debug("xxxxxxx");



		//MessageFactory mfactory = MessageFactory.newInstance();
		//SOAPMessage soapMessage = mfactory.createMessage();
		//SOAPBody soapBody = soapMessage.getSOAPBody();

        JAXBContext contexto = JAXBContext.newInstance(request.getClass());
        Marshaller marshaller = contexto.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
       // marshaller.marshal(request, System.out);
        StringWriter sw = new StringWriter();
        marshaller.marshal(request, sw);
        //marshaller.
        //soapMessage.saveChanges();
        //soapMessage.
        //soapMessage.writeTo(sw);


		String soapHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<soap:Body>";
		String soapFooter = "</soap:Body></soap:Envelope>";
		//"<FECompUltimoAutorizado xmlns=\"http://ar.gov.afip.dif.FEV1/\">
		//<Auth><Token></Token>
		//<Sign></Sign><Cuit>20301766700</Cuit></Auth><PtoVta>1</PtoVta><CbteTipo>1</CbteTipo></FECompUltimoAutorizado>";
		Logger.debug("xxxxxxxxxxx");
			Logger.debug("xxxxxxxxx "+sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", ""));
			Logger.debug("xxxxxxx");
		String sw1 = sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
        String sopa = soapHeader+sw1+soapFooter;
         //

        Logger.debug("xxxxxxxxx "+sopa);
		Promise<WS.Response> result2 = WS.url("https://servicios1.afip.gov.ar/wsfev1/service.asmx").setContentType("text/xml").post(sopa);
		//call webservice and get response
		//FECompUltimoAutorizadoResponse response = (FECompUltimoAutorizadoResponse) webServiceTemplate.marshalSendAndReceive(request);
		Logger.debug("vvvvvvvvvvvvvvvvvv22");

		//XMLInputFactory xif = XMLInputFactory.newInstance();
		InputStream targetStream = new ByteArrayInputStream(result2.get().getBody().getBytes());
        //XMLStreamReader reader = xif.createXMLStreamReader(targetStream);

        //reader.nextTag(); // Advance to Envelope tag
        //reader.nextTag();
        //reader.next(); // Advance to Body tag
        //xsr.nextTag(); // Advance to getNumberResponse tag
        //System.out.println(xsr.getNamespaceContext().getNamespaceURI("soap"));

        /*while(reader.hasNext()){
        	reader.next();
            if(reader.getEventType() == XMLStreamReader.START_ELEMENT){
                System.out.println(reader.getLocalName());
                System.out.println(reader.getName().getLocalPart());
            }
        }


        int eventType = reader.getEventType();
        System.out.println(eventType);   // 7, START_DOCUMENT
        System.out.println(reader);      // xerces

        while (reader.hasNext()) {

            eventType = reader.next();

            if (eventType == XMLEvent.START_ELEMENT) {

                switch (reader.getName().getLocalPart()) {

                    case "staff":
                        String id = reader.getAttributeValue(null, "id");
                        System.out.printf("Staff id : %s%n", id);
                        break;

                    case "name":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("Name : %s%n", reader.getText());
                        }
                        break;

                    case "role":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("Role : %s%n", reader.getText());
                        }
                        break;

                    case "salary":
                        String currency = reader.getAttributeValue(null, "currency");
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            String salary = reader.getText();
                            System.out.printf("Salary [Currency] : %,.2f [%s]%n",
                              Float.parseFloat(salary), currency);
                        }
                        break;

                    case "bio":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("Bio : %s%n", reader.getText());
                        }
                        break;
                }

            }

            if (eventType == XMLEvent.END_ELEMENT) {
                // if </staff>
                if (reader.getName().getLocalPart().equals("staff")) {
                    System.out.printf("%n%s%n%n", "---");
                }
            }

        }*/



        //Logger.debug("1x "+reader.getText());
		Logger.debug("2x "+result2.get().getBody());
		Logger.debug("3x "+result2);

		//MessageFactory mfactory = MessageFactory.newInstance();
		//SOAPMessage soapMessage = mfactory.createMessage();
		//soapMessage.set
		//SOAPBody soapBody =result2.get().getBody().getSOAPPart().getEnvelope().getBody();

		//SOAPMessage msg = mfactory.createMessage();
		//msg.getSOAPPart().setContent(request);
	    //SOAPBody body = msg.getSOAPBody();

		Logger.debug("vvvvvvvvvvvvvvvvvv22");





		JAXBContext jaxbContext = JAXBContext.newInstance(FECompUltimoAutorizadoResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //StringReader reader2 = new StringReader("<FECompUltimoAutorizadoResponse xmlns=\"http://ar.gov.afip.dif.FEV1/\"><FECompUltimoAutorizadoResult><PtoVta>0</PtoVta><CbteTipo>0</CbteTipo><CbteNro>0</CbteNro><Errors><Err><Code>600</Code><Msg>ValidacionDeToken: No validaron las fechas del token GenTime, ExpTime, NowUTC: 1652102088 (5/9/2022 1:14:18 PM), 1652145348 (5/10/2022 1:15:48 AM), 6/29/2022 1:22:25 PM</Msg></Err></Errors></FECompUltimoAutorizadoResult></FECompUltimoAutorizadoResponse>");

        //String xml = "<A><B><id>0</id></B><B><id>1</id></B></A>";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        org.w3c.dom.Document doc = dbf.newDocumentBuilder().parse(targetStream);

        XPath xPath = XPathFactory.newInstance().newXPath();
        Node result3 = (Node)xPath.evaluate("//FECompUltimoAutorizadoResponse", doc, XPathConstants.NODE);

        //DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //org.w3c.dom.Document doc =   dBuilder.parse(targetStream);
        //doc.getDocumentElement().normalize();


        //System.out.println("rrrrrrrrrrrrrrrrrrrr");
        //System.out.println(doc.getDocumentElement().getElementsByTagName("FECompUltimoAutorizadoResponse").toString());

        //System.out.println(nodeToString(result3));
        //System.out.println("rrrrrrrrrrrrrrrrrrrr");

        StringReader finalreader = new StringReader(nodeToString(result3));
        FECompUltimoAutorizadoResponse datos = (FECompUltimoAutorizadoResponse) jaxbUnmarshaller.unmarshal(finalreader);

        System.out.println("-----------getFECompUltimoAutorizadoResult-------------");
        System.out.println(datos.getFECompUltimoAutorizadoResult());
        System.out.println(datos.getFECompUltimoAutorizadoResult().getCbteTipo());
        System.out.println("getCbteNro: "+datos.getFECompUltimoAutorizadoResult().getCbteNro());
        System.out.println(datos.getFECompUltimoAutorizadoResult().getPtoVta());
        System.out.println("-----------------------------------");
        System.out.println("Valor: "+datos.getFECompUltimoAutorizadoResult().getErrors());

        if(datos.getFECompUltimoAutorizadoResult().getErrors() != null) {
	        for(Err a : datos.getFECompUltimoAutorizadoResult().getErrors().getErr()) {

	        	System.out.println("a.getMsg();: "+a.getMsg());
	        }
        }
        Logger.debug("vvvvvvvvvvvvvvvvvv333");

        /************SET AUTH***********************/
        FECAESolicitar fECAESolicitar = new FECAESolicitar();
        fECAESolicitar.setAuth(auth);
        /************FIN SET AUTH***********************/


        FECAERequest fcaer = new FECAERequest();


        /************SET CAB REQ***********************/
        /*
         * 	<ar:FeCabReq>
			 <ar:CantReg>int</ar:CantReg>
			 <ar:PtoVta>int</ar:PtoVta>
			 <ar:CbteTipo>int</ar:CbteTipo>
			</ar:FeCabReq>
         */
        FECAECabRequest fECAECabRequest = new FECAECabRequest();
        fECAECabRequest.setCantReg(1);
        fECAECabRequest.setCbteTipo(1);
        fECAECabRequest.setPtoVta(1);

        fcaer.setFeCabReq(fECAECabRequest);
        /************FIN SET CAB REQ***********************/

        /************SET DETALLE CAE***********************/
        /*
         <ar:FeDetReq>
			 <ar:FECAEDetRequest>
				 <ar:Concepto>int</ar:Concepto>
				 <ar:DocTipo>int</ar:DocTipo>
				 <ar:DocNro>long</ar:DocNro>
				 <ar:CbteDesde>long</ar:CbteDesde>
				 <ar:CbteHasta>long</ar:CbteHasta>
				 <ar:CbteFch>string</ar:CbteFch>
				 <ar:ImpTotal>double</ar:ImpTotal>
				 <ar:ImpTotConc>double</ar:ImpTotConc>
				 <ar:ImpNeto>double</ar:ImpNeto>
				 <ar:ImpOpEx>double</ar:ImpOpEx>
				 <ar:ImpTrib>double</ar:ImpTrib>
				 <ar:ImpIVA>double</ar:ImpIVA>
				 <ar:FchServDesde>string</ar:FchServDesde>
				 <ar:FchServHasta>string</ar:FchServHasta>
				 <ar:FchVtoPago>string</ar:FchVtoPago>
				 <ar:MonId>string</ar:MonId>
				 <ar:MonCotiz>double</ar:MonCotiz>
				 <ar:CbtesAsoc>
					 <ar:CbteAsoc>
						 <ar:Tipo>short</ar:Tipo>
						 <ar:PtoVta>int</ar:PtoVta>
						 <ar:Nro>long</ar:Nro>
					 </ar:CbteAsoc>
				 </ar:CbtesAsoc>
				 <ar:Tributos>
					 <ar:Tributo>
						 <ar:Id>short</ar:Id>
						 <ar:Desc>string</ar:Desc>
						 <ar:BaseImp>double</ar:BaseImp>
						 <ar:Alic>double</ar:Alic>
						 <ar:Importe>double</ar:Importe>
					 </ar:Tributo>
				 </ar:Tributos>
				 <ar:Iva>
					 <ar:AlicIva>
					 <ar:Id>short</ar:Id>
					 <ar:BaseImp>double</ar:BaseImp>
					 <ar:Importe>double</ar:Importe>
					 </ar:AlicIva>
				 </ar:Iva>
				 <ar:Opcionales>
					 <ar:Opcional>
						 <ar:Id>string</ar:Id>
						 <ar:Valor>string</ar:Valor>
					 </ar:Opcional>
				 </ar:Opcionales>
			</ar:FECAEDetRequest>
		</ar:FeDetReq>
         */


        FECAEDetRequest fECAEDetRequest = new FECAEDetRequest();

        fECAEDetRequest.setConcepto(1);//<ar:Concepto>int</ar:Concepto>
        fECAEDetRequest.setDocTipo(80);//<ar:DocTipo>int</ar:DocTipo>
        fECAEDetRequest.setDocNro(Long.parseLong("20002307554"));//<ar:DocNro>long</ar:DocNro>


        Long CbteNro = new Long(datos.getFECompUltimoAutorizadoResult().getCbteNro())+1;

        System.out.println("---------CbteNroCbteNroCbteNroCbteNroCbteNro----------"+CbteNro);

        fECAEDetRequest.setCbteDesde(CbteNro);//<ar:CbteDesde>long</ar:CbteDesde>
        fECAEDetRequest.setCbteHasta(CbteNro);//<ar:CbteHasta>long</ar:CbteHasta>
        fECAEDetRequest.setCbteFch("20230120");//<ar:CbteFch>string</ar:CbteFch>

        fECAEDetRequest.setImpTotal(5000);//<ar:ImpTotal>double</ar:ImpTotal>
        fECAEDetRequest.setImpTotConc(5000);//<ar:ImpTotConc>double</ar:ImpTotConc>
        fECAEDetRequest.setImpNeto(0);//<ar:ImpNeto>double</ar:ImpNeto>
        fECAEDetRequest.setImpOpEx(0);//<ar:ImpOpEx>double</ar:ImpOpEx>
        fECAEDetRequest.setImpTrib(0);//<ar:ImpTrib>double</ar:ImpTrib>
        fECAEDetRequest.setImpIVA(0);//<ar:ImpIVA>double</ar:ImpIVA>
        //fECAEDetRequest.setFchServDesde(value);//<ar:FchServDesde>string</ar:FchServDesde>
        //fECAEDetRequest.setFchServHasta(value);//<ar:FchServHasta>string</ar:FchServHasta>
        //fECAEDetRequest.setFchVtoPago(value);//<ar:FchVtoPago>string</ar:FchVtoPago>
        fECAEDetRequest.setMonId("PES");//<ar:MonId>string</ar:MonId>
        fECAEDetRequest.setMonCotiz(1);//<ar:MonCotiz>double</ar:MonCotiz>


        //.getMsg();: El campo  'Importe Total' ImpTotal, debe ser igual  a la  suma de ImpTotConc + ImpNeto + ImpOpEx + ImpTrib + ImpIVA.
        //a.getMsg();: Si ImpNeto es mayor a 0 el objeto IVA es obligatorio.
        //a.getMsg();: Si el comprobante es Debito o Credito, enviar estructura CbteAsoc o PeriodoAsoc.
        ArrayOfFECAEDetRequest arrayOfFECAEDetRequest = new ArrayOfFECAEDetRequest();
        List<FECAEDetRequest> fecaeDetRequests = arrayOfFECAEDetRequest.getFECAEDetRequest();


        fecaeDetRequests.add(fECAEDetRequest);

        fcaer.setFeDetReq(arrayOfFECAEDetRequest);


        /************FIN SET DETALLE CAE***********************/



        fECAESolicitar.setFeCAEReq(fcaer);

        JAXBContext contexto2 = JAXBContext.newInstance(fECAESolicitar.getClass());
        Marshaller marshaller2 = contexto2.createMarshaller();
        marshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw2 = new StringWriter();
        marshaller2.marshal(fECAESolicitar, sw2);

        String sw12 = sw2.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
        String sopa2 = soapHeader+sw12+soapFooter;
        Promise<WS.Response> result222 = WS.url("https://servicios1.afip.gov.ar/wsfev1/service.asmx").setContentType("text/xml").post(sopa2);
		InputStream targetStream2 = new ByteArrayInputStream(result222.get().getBody().getBytes());



        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
        org.w3c.dom.Document doc2 = dbf2.newDocumentBuilder().parse(targetStream2);

        XPath xPath2 = XPathFactory.newInstance().newXPath();
        Node result32 = (Node)xPath2.evaluate("//FECAESolicitarResponse", doc2, XPathConstants.NODE);

        StringReader finalreader2 = new StringReader(nodeToString(result32));
        System.out.println(finalreader2);

		/////////////////////////////

        JAXBContext jaxbContext2 = JAXBContext.newInstance(FECAESolicitarResponse.class);
        Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();

        FECAESolicitarResponse datos2 = (FECAESolicitarResponse) jaxbUnmarshaller2.unmarshal(finalreader2);
        System.out.println("-----------------------------------");
        //System.out.println("-----------------------------------"+
        //datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0));




        if(datos2.getFECAESolicitarResult().getErrors() != null) {
	        for(Err a : datos2.getFECAESolicitarResult().getErrors().getErr()) {

	        	System.out.println("a.getMsg();: "+a.getMsg());
	        }
        }
        System.out.println(datos2.getFECAESolicitarResult().getFeCabResp().getCbteTipo());
        System.out.println(datos2.getFECAESolicitarResult().getFeCabResp().getCuit());
        System.out.println(datos2.getFECAESolicitarResult().getFeCabResp().getFchProceso());
        System.out.println(datos2.getFECAESolicitarResult().getFeCabResp().getPtoVta());
        System.out.println(datos2.getFECAESolicitarResult().getFeCabResp().getReproceso());
        System.out.println(datos2.getFECAESolicitarResult().getFeCabResp().getResultado());
        System.out.println(datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getCAE());
        System.out.println("---------CAAAAAAAAEEE----------");
        System.out.println("getCAE: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getCAE());
        System.out.println("getCAEFchVto: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getCAEFchVto());
        System.out.println("getCbteDesde: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getCbteDesde());
        System.out.println("getCbteHasta: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getCbteHasta());
        System.out.println("getConcepto: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getConcepto());
        System.out.println("getDocNro: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getDocNro());
        System.out.println("getDocTipo: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getDocTipo());
        System.out.println("getResultado: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getResultado());
        System.out.println("getObservaciones: "+datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getObservaciones());


        if(datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getObservaciones() != null) {
	        for(Obs a : datos2.getFECAESolicitarResult().getFeDetResp().getFECAEDetResponse().get(0).getObservaciones().getObs()) {

	        	System.out.println("a.getMsg();: "+ a.getMsg());
	        }
        }


        System.out.println("---------CAAAAAAAAEEE----------");

        System.out.println("---------FINNNNNNNNNNNNNNNNNN----------");




		//FECompUltimoAutorizadoResponse response = (FECompUltimoAutorizadoResponse) webServiceTemplate.marshalSendAndReceive(request);
		//FERecuperaLastCbteResponse ultimoComprobante = response.getFECompUltimoAutorizadoResult();

		//fill result and check for errors
		//if (ultimoComprobante != null)
		//result = ultimoComprobante.getCbteNro();
		//checkErrors(ultimoComprobante.getErrors(), ultimoComprobante.getEvents());
		return result;
	}


	public int crearComprobantesAutomaticos() throws IOException {

		if (play.Play.isProd()) {
			Logger.debug("Cache.get(\"corriendo_afip\")----> "+Cache.get("corriendo_afip"));
			if(Cache.get("corriendo_afip") == null || Cache.get("corriendo_afip") == "false" ) {
				Logger.debug("rrrrrrrrrrrrrrrrrrr2 ");
				Cache.set("corriendo_afip","true");
				List<RecuperoFactura> rf = RecuperoFactura.find.select("id,cae,estado_id")
											 .fetch("puntoVenta","tipo_facturacion,habilitado")
											 .where()
											.eq("estado_id",Estado.RECUPERO_FACTURA_APROBADO)
											.eq("puntoVenta.tipo_facturacion", "ws")
											.eq("puntoVenta.habilitado", true)
											.disjunction()
											.isNull("cae")
											.eq("cae", "")
											.endJunction()
											.findList();

				if(rf.size() > 0) {
					Logger.debug("HAY FACTURAS AFIP PARA CORRER "+rf.size());
					for(RecuperoFactura rfx :rf) {
						correrFacturaAfip(rfx.id);
						//Logger.debug("xxxxxxxxxxxx "+rfx.id);
					}
				}else {
					Logger.debug("NO HAY FACTURAS AFIP PARA CORRER ");
				}

				List<RecuperoNotaCredito> rc = RecuperoNotaCredito.find.select("id,cae")
						.fetch("recupero_factura","estado_id")
						.fetch("puntoVenta","tipo_facturacion,habilitado")
						.where()
						.eq("recupero_factura.estado_id",Estado.RECUPERO_FACTURA_APROBADO)
						.eq("puntoVenta.tipo_facturacion", "ws")
						.eq("puntoVenta.habilitado", true)
						.disjunction()
						.isNull("cae")
						.eq("cae", "")
						.endJunction()
						.findList();

				if(rc.size() > 0) {
					Logger.debug("HAY NC AFIP PARA CORRER "+rc.size());
					for(RecuperoNotaCredito rfx :rc) {
						correrNota(rfx.id,TipoComprobante.NOTA_CREDITO);
						//Logger.debug("xxxxxxxxxxxx22 "+rfx.id);
					}
				}else {
					Logger.debug("NO HAY NC AFIP PARA CORRER ");
				}

				List<RecuperoNotaDebito> rd = RecuperoNotaDebito.find.select("id,cae")
						.fetch("recupero_factura","estado_id")
						.fetch("puntoVenta","tipo_facturacion,habilitado")
						.where()
						.eq("recupero_factura.estado_id",Estado.RECUPERO_FACTURA_APROBADO)
						.eq("puntoVenta.tipo_facturacion", "ws")
						.eq("puntoVenta.habilitado", true)
						.disjunction()
						.isNull("cae")
						.eq("cae", "")
						.endJunction()
						.findList();

				if(rd.size() > 0) {
					Logger.debug("HAY NC AFIP PARA CORRER "+rc.size());
					for(RecuperoNotaDebito rfx :rd) {
						correrNota(rfx.id,TipoComprobante.NOTA_DEBITO);
						//Logger.debug("xxxxxxxxxxxx33 "+rfx.id);
					}
				}else {
					Logger.debug("NO HAY ND AFIP PARA CORRER ");
				}
				Cache.set("corriendo_afip","false");
			}else {
				Cache.set("corriendo_afip","false");
			}
		}

		return 1;
	}

	public static void correrFacturaAfip(Long idFactura) throws IOException{
		if (play.Play.isProd()) {
			try {
				AfipController ac = new AfipController();
				ObjectNode ret = ac.setComprobante(idFactura,TipoComprobante.FACTURA);

				if(ret.get("success").asText().compareTo("true")  == 0) {
					RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,idFactura.intValue(), null,null,TipoComprobante.FACTURA,ret.get("cae").asText(),"FACTURA","",new Date());
					ram.save();
				}else {
					RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,idFactura.intValue(), null,null,TipoComprobante.FACTURA,null,"FACTURA ERROR",ret.get("error").asText(),new Date());
					ram.save();
					//error
					//flash("error", "error: "+ret.get("error").asText());
				}
			}catch (Exception e) {
				//error
				//flash("error", "error: "+e);
			}
		}else {
			//error
			//flash("error", "error: NO ES PRODUCCION");
		}
	}

	public static void correrNota(Long idNota,int tipoComprobante) throws IOException{

		if (play.Play.isProd()) {
			try {
				AfipController ac = new AfipController();
				ObjectNode ret = null;
				if(tipoComprobante == TipoComprobante.NOTA_CREDITO) {

					//RecuperoNotaCredito rc = RecuperoNotaCredito.find.byId(idNota);

					//if(rc.recupero_factura.cae != null && !rc.recupero_factura.cae.isEmpty()) {
						ret = ac.setComprobante(idNota,TipoComprobante.NOTA_CREDITO);
						if(ret.get("success").asText().compareTo("true")  == 0) {
							//flash("success", "CAEE: "+ret.get("cae").asText());
							RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null, idNota.intValue(),null,TipoComprobante.NOTA_CREDITO,ret.get("cae").asText(),"NOTA CREDITO","",new Date());
							ram.save();
						}else if(ret.get("error") != null){
							//flash("error", "error: "+ret.get("error").asText());
							RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null, null,idNota.intValue(),null,TipoComprobante.NOTA_CREDITO,null,"NOTA CREDITO ERROR",ret.get("error").asText(),new Date());
							ram.save();
						}
					//}else {
						//	flash("error", "error: La factura no tiene cae asignado");
						//}


				}else if(tipoComprobante == TipoComprobante.NOTA_DEBITO) {

					//RecuperoNotaDebito rd = RecuperoNotaDebito.find.byId(idNota);
					//if(rd.recupero_factura.cae != null && !rd.recupero_factura.cae.isEmpty()) {
						ret = ac.setComprobante(idNota,TipoComprobante.NOTA_DEBITO);
						if(ret.get("success").asText().compareTo("true")  == 0) {
							//flash("success", "CAEE: "+ret.get("cae").asText());
							RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, idNota.intValue(),TipoComprobante.NOTA_DEBITO,ret.get("cae").asText(),"NOTA_DEBITO","",new Date());
							ram.save();
						}else if(ret.get("error") != null){
							//flash("error", "error: "+ret.get("error").asText());
							RecuperoAfipMovimiento ram = new RecuperoAfipMovimiento(null,null,null, idNota.intValue(),TipoComprobante.NOTA_DEBITO,null,"NOTA_DEBITO ERROR",ret.get("error").asText(),new Date());
							ram.save();
						}
						//}else {

						//	flash("error", "error: La factura no tiene cae asignado");
						//}


				}



			}catch (Exception e) {
				//flash("error", "error: "+e);
			}
		}else {
			//flash("error", "error: NO ES PRODUCCION");
		}
	}


	/*
	private void checkErrors(ArrayOfErr errors, ArrayOfEvt events){
		this.hasIssues = false;
		this.errors = "";
		this.events = "";
		//Check for errors
		if (errors != null){
			for (Err error : errors.getErr()){
				if (this.errors != "")
					this.errors += "\n";
				this.errors += "Error: (" + Integer.toString(error.getCode()) + ") " + error.getMsg();
				this.hasIssues = true;
			}
		}
		//Check for events
		if (events != null){
			for (Evt event : events.getEvt()){
				if (this.events != "")
					this.events += "\n";
				this.events += "Event: (" + Integer.toString(event.getCode()) + ") " + event.getMsg();
				this.hasIssues = true;
			}
		}
	}*/
}

