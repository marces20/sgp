//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.05.05 a las 12:50:51 PM ART 
//


package utils.afip.wsfe.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FECAEDetResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FECAEDetResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ar.gov.afip.dif.FEV1/}FEDetResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CAE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CAEFchVto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FECAEDetResponse", propOrder = {
    "cae",
    "caeFchVto"
})
public class FECAEDetResponse
    extends FEDetResponse
{

    @XmlElement(name = "CAE")
    protected String cae;
    @XmlElement(name = "CAEFchVto")
    protected String caeFchVto;

    /**
     * Obtiene el valor de la propiedad cae.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAE() {
        return cae;
    }

    /**
     * Define el valor de la propiedad cae.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAE(String value) {
        this.cae = value;
    }

    /**
     * Obtiene el valor de la propiedad caeFchVto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAEFchVto() {
        return caeFchVto;
    }

    /**
     * Define el valor de la propiedad caeFchVto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAEFchVto(String value) {
        this.caeFchVto = value;
    }

}
