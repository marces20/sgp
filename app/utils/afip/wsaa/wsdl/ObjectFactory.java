//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.05.05 a las 12:50:51 PM ART 
//


package utils.afip.wsaa.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsaa.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault_QNAME = new QName("https://wsaahomo.afip.gov.ar/ws/services/LoginCms", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsaa.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginCms }
     * 
     */
    public LoginCms createLoginCms() {
        return new LoginCms();
    }

    /**
     * Create an instance of {@link LoginCmsResponse }
     * 
     */
    public LoginCmsResponse createLoginCmsResponse() {
        return new LoginCmsResponse();
    }

    /**
     * Create an instance of {@link LoginFault }
     * 
     */
    public LoginFault createLoginFault() {
        return new LoginFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://wsaahomo.afip.gov.ar/ws/services/LoginCms", name = "fault")
    public JAXBElement<LoginFault> createFault(LoginFault value) {
        return new JAXBElement<LoginFault>(_Fault_QNAME, LoginFault.class, null, value);
    }

}
