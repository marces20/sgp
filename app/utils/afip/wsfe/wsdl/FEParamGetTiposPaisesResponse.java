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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FEParamGetTiposPaisesResult" type="{http://ar.gov.afip.dif.FEV1/}FEPaisResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "feParamGetTiposPaisesResult"
})
@XmlRootElement(name = "FEParamGetTiposPaisesResponse")
public class FEParamGetTiposPaisesResponse {

    @XmlElement(name = "FEParamGetTiposPaisesResult")
    protected FEPaisResponse feParamGetTiposPaisesResult;

    /**
     * Obtiene el valor de la propiedad feParamGetTiposPaisesResult.
     * 
     * @return
     *     possible object is
     *     {@link FEPaisResponse }
     *     
     */
    public FEPaisResponse getFEParamGetTiposPaisesResult() {
        return feParamGetTiposPaisesResult;
    }

    /**
     * Define el valor de la propiedad feParamGetTiposPaisesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link FEPaisResponse }
     *     
     */
    public void setFEParamGetTiposPaisesResult(FEPaisResponse value) {
        this.feParamGetTiposPaisesResult = value;
    }

}
