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

import play.Logger;
import play.Play;
import utils.afip.wsfe.wsdl.*;
import utils.afip.wsfe.wsdl.ArrayOfErr;
import utils.afip.wsfe.wsdl.ArrayOfEvt;
import utils.afip.wsfe.wsdl.Err;
import utils.afip.wsfe.wsdl.Evt;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import play.libs.WS;
import static play.libs.F.Function;
import static play.libs.F.Promise;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class AfipController {
	
	public static String xxx() throws IOException, DatatypeConfigurationException {

		String LoginTicketResponse = null;
	
		//System.setProperty("http.proxyHost", "");
		//System.setProperty("http.proxyPort", "80");
		Logger.debug("111111111111111");
		// Read config from phile
		Properties config = new Properties();
		
		//try {
		//	config.load(new FileInputStream("./wsaa_client.properties"));
		//} catch (Exception e) {
		//	e.printStackTrace();
		//} 
		
		String endpoint ="https://wsaahomo.afip.gov.ar/ws/services/LoginCms"; //config.getProperty("endpoint","http://wsaahomo.afip.gov.ar/ws/services/LoginCms"); 
		//String service = config.getProperty("service","test");
		String dstDN = "CN=wsaahomo, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239";//config.getProperty("dstdn","cn=wsaahomo,o=afip,c=ar,serialNumber=CUIT 33693450239");
		 

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
		
		Long TicketTime = new Long(config.getProperty("TicketTime","36000"));
		 
		// Create LoginTicketRequest_xml_cms
		
		InputStream in = Play.application().resourceAsStream("resources/certificado3.p12");
		String dirTemp = System.getProperty("java.io.tmpdir");
		File archivo = new File(dirTemp+"/certificado3.p12");
		 
		Files.copy(in, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		byte [] LoginTicketRequest_xml_cms = create_cms(archivo.getAbsolutePath(), "parquesalud", "parquesalud", dstDN, "wsfe", new Long(36000));
																				  
		//byte [] LoginTicketRequest_xml_cms = create_cms(p12file, p12pass, signer, dstDN, service, TicketTime);
			
		// Invoke AFIP wsaa and get LoginTicketResponse
		Logger.debug("endpoint "+endpoint);
		Logger.debug("LoginTicketRequest_xml_cms "+LoginTicketRequest_xml_cms);
		try {
			LoginTicketResponse = invoke_wsaa ( LoginTicketRequest_xml_cms, endpoint );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Get token & sign from LoginTicketResponse
		try {
			Reader tokenReader = new StringReader(LoginTicketResponse);
			Document tokenDoc = new SAXReader(false).read(tokenReader);
			
			String token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
			String sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");
			
			System.out.println("TOKEN: " + token);
			System.out.println("SIGN: " + sign);
		} catch (Exception e) {
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
			e.printStackTrace();
		}        
		return (LoginTicketResponse);
	}

	//
	// Create the CMS Message
	//
	public static byte [] create_cms (String p12file, String p12pass, String signer, String dstDN, String service, Long TicketTime) throws DatatypeConfigurationException {

		PrivateKey pKey = null;
		X509Certificate pCertificate = null;
		byte [] asn1_cms = null;
		CertStore cstore = null;
		String LoginTicketRequest_xml;
		String SignerDN = null;

		//
		// Manage Keys & Certificates
		//
		try {
			// Create a keystore using keys from the pkcs#12 p12file
			KeyStore ks = KeyStore.getInstance("pkcs12");
			
			Logger.debug("2222  "+p12file);
			
			FileInputStream p12stream = new FileInputStream ( p12file ) ;
			ks.load(p12stream, p12pass.toCharArray());
			p12stream.close();
			
			
			

			// Get Certificate & Private key from KeyStore
			pKey = (PrivateKey) ks.getKey(signer, p12pass.toCharArray());
			Logger.debug("4444  "+ks.size());
			pCertificate = (X509Certificate)ks.getCertificate(signer);
			Logger.debug("5555  "+pCertificate);
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
			e.printStackTrace();
		} 

		//
		// Create XML Message
		// 
		LoginTicketRequest_xml = create_LoginTicketRequest(SignerDN, dstDN, service, TicketTime);
		
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
		
		exptime.setTime(new Date(GenTime.getTime()+TicketTime));
		
		//XMLGregorianCalendarImpl XMLGenTime = new XMLGregorianCalendarImpl(gentime);
		//XMLGregorianCalendarImpl XMLExpTime = new XMLGregorianCalendarImpl(exptime);
		XMLGregorianCalendar XMLGenTime = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(gentime);
		XMLGregorianCalendar XMLExpTime = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(exptime);
		 
		
		
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
		
		//System.out.println("TRA: " + LoginTicketRequest_xml);
		
		return (LoginTicketRequest_xml);
	}
	
	//public int getUltimoComprobante(TRA tra, int puntoVenta, int tipoComprobante){
	public int getUltimoComprobante( int puntoVenta, int tipoComprobante) throws JAXBException, SOAPException, ParserConfigurationException,  IOException, XMLStreamException, SAXException, XPathExpressionException, TransformerException{
		
		int result = -1;
		
		//WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		//webServiceTemplate.setDefaultUri(tra.getTargetServiceUrl());
		//webServiceTemplate.setDefaultUri("https://wswhomo.afip.gov.ar/wsfev1/service.asmx");
		
		//Create request and params, including Auth
		FEAuthRequest auth = new FEAuthRequest();
		auth.setCuit(Long.parseLong("20301766700"));
		auth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgc3JjPSJDTj13c2FhaG9tbywgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiIHVuaXF1ZV9pZD0iMjE1ODA4MDQyNCIgZ2VuX3RpbWU9IjE2NTkwOTg1NDIiIGV4cF90aW1lPSIxNjU5MTQxODAyIi8+CiAgICA8b3BlcmF0aW9uIHR5cGU9ImxvZ2luIiB2YWx1ZT0iZ3JhbnRlZCI+CiAgICAgICAgPGxvZ2luIGVudGl0eT0iMzM2OTM0NTAyMzkiIHNlcnZpY2U9IndzZmUiIHVpZD0iU0VSSUFMTlVNQkVSPUNVSVQgMjAyNDc3ODEwMzAsIENOPXBhcnF1ZXNhbHVkIiBhdXRobWV0aG9kPSJjbXMiIHJlZ21ldGhvZD0iMjIiPgogICAgICAgICAgICA8cmVsYXRpb25zPgogICAgICAgICAgICAgICAgPHJlbGF0aW9uIGtleT0iMjAzMDE3NjY3MDAiIHJlbHR5cGU9IjQiLz4KICAgICAgICAgICAgPC9yZWxhdGlvbnM+CiAgICAgICAgPC9sb2dpbj4KICAgIDwvb3BlcmF0aW9uPgo8L3Nzbz4K");
		auth.setSign("OhZBnjwwABL+OkePFlFev0jICjYnqasoB3m5GEw1XXbpBh96rF8QcP52foo2bH1kPUnP72Z56rlYB3js/KD23bzcSWWraLcThWF8thU2NtMVyc77/qe71D51FartY8oPIjOb3jt/mdQnnCSPYuqNcLcqViyICJxWdMeIqXQqMWo=");
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
		//<Auth><Token>PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgc3JjPSJDTj13c2FhaG9tbywgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5
		//MzQ1MDIzOSIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiIHVuaXF1ZV9pZD0iMzczMTgxNDA3OCIgZ2VuX3RpbWU9IjE2NTIxMDIwODgiIGV4cF90aW1lPSIxNjUyMTQ1MzQ4Ii8+CiAgICA8b3BlcmF0aW9uIHR5cGU9ImxvZ2luIiB2YWx1ZT0iZ3JhbnRlZ
		//CI+CiAgICAgICAgPGxvZ2luIGVudGl0eT0iMzM2OTM0NTAyMzkiIHNlcnZpY2U9IndzZmUiIHVpZD0iU0VSSUFMTlVNQkVSPUNVSVQgMjAyNDc3ODEwMzAsIENOPXBhcnF1ZXNhbHVkIiBhdXRobWV0aG9kPSJjbXMiIHJlZ21ldGhvZD0iMjIiPgogICAgICAgIC
		//AgICA8cmVsYXRpb25zPgogICAgICAgICAgICAgICAgPHJlbGF0aW9uIGtleT0iMjAzMDE3NjY3MDAiIHJlbHR5cGU9IjQiLz4KICAgICAgICAgICAgPC9yZWxhdGlvbnM+CiAgICAgICAgPC9sb2dpbj4KICAgIDwvb3BlcmF0aW9uPgo8L3Nzbz4K</Token>
		//<Sign></Sign><Cuit>20301766700</Cuit></Auth><PtoVta>1</PtoVta><CbteTipo>1</CbteTipo></FECompUltimoAutorizado>";
		 Logger.debug("xxxxxxxxxxx");
			Logger.debug("xxxxxxxxx "+sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", ""));
			Logger.debug("xxxxxxx");
		String sw1 = sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");	
        String sopa = soapHeader+sw1+soapFooter;
         //
        
        Logger.debug("xxxxxxxxx "+sopa);
		Promise<WS.Response> result2 = WS.url("https://wswhomo.afip.gov.ar/wsfev1/service.asmx")
										.setContentType("text/xml").post(sopa);
		//call webservice and get response
		//FECompUltimoAutorizadoResponse response = (FECompUltimoAutorizadoResponse) webServiceTemplate.marshalSendAndReceive(request);
		Logger.debug("vvvvvvvvvvvvvvvvvv22");
		
		XMLInputFactory xif = XMLInputFactory.newInstance();
		InputStream targetStream = new ByteArrayInputStream(result2.get().getBody().getBytes());
        XMLStreamReader reader = xif.createXMLStreamReader(targetStream);
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
        StringReader reader2 = new StringReader("<FECompUltimoAutorizadoResponse xmlns=\"http://ar.gov.afip.dif.FEV1/\"><FECompUltimoAutorizadoResult><PtoVta>0</PtoVta><CbteTipo>0</CbteTipo><CbteNro>0</CbteNro><Errors><Err><Code>600</Code><Msg>ValidacionDeToken: No validaron las fechas del token GenTime, ExpTime, NowUTC: 1652102088 (5/9/2022 1:14:18 PM), 1652145348 (5/10/2022 1:15:48 AM), 6/29/2022 1:22:25 PM</Msg></Err></Errors></FECompUltimoAutorizadoResult></FECompUltimoAutorizadoResponse>");
        
        String xml = "<A><B><id>0</id></B><B><id>1</id></B></A>";
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
        //    System.out.println(datos);
        System.out.println("Valor: "+datos.getFECompUltimoAutorizadoResult().getErrors());
        
        for(Err a : datos.getFECompUltimoAutorizadoResult().getErrors().getErr()) {
        	
        	System.out.println("a.getMsg();: "+a.getMsg());
        }
		
        Logger.debug("vvvvvvvvvvvvvvvvvv333");
		//FECompUltimoAutorizadoResponse response = (FECompUltimoAutorizadoResponse) webServiceTemplate.marshalSendAndReceive(request);
		//FERecuperaLastCbteResponse ultimoComprobante = response.getFECompUltimoAutorizadoResult();
		
		//fill result and check for errors
		//if (ultimoComprobante != null)
		//result = ultimoComprobante.getCbteNro();
		//checkErrors(ultimoComprobante.getErrors(), ultimoComprobante.getEvents());
		return result;
	}
	
	private static String nodeToString(Node node)
			throws TransformerException
			{
			    StringWriter buf = new StringWriter();
			    Transformer xform = TransformerFactory.newInstance().newTransformer();
			    xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			    xform.transform(new DOMSource(node), new StreamResult(buf));
			    return(buf.toString());
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
