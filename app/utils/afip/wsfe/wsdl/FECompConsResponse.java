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
 * <p>Clase Java para FECompConsResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FECompConsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ar.gov.afip.dif.FEV1/}FECAEDetRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Resultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodAutorizacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EmisionTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FchVto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FchProceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Observaciones" type="{http://ar.gov.afip.dif.FEV1/}ArrayOfObs" minOccurs="0"/&gt;
 *         &lt;element name="PtoVta" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CbteTipo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FECompConsResponse", propOrder = {
    "resultado",
    "codAutorizacion",
    "emisionTipo",
    "fchVto",
    "fchProceso",
    "observaciones",
    "ptoVta",
    "cbteTipo"
})
public class FECompConsResponse
    extends FECAEDetRequest
{

    @XmlElement(name = "Resultado")
    protected String resultado;
    @XmlElement(name = "CodAutorizacion")
    protected String codAutorizacion;
    @XmlElement(name = "EmisionTipo")
    protected String emisionTipo;
    @XmlElement(name = "FchVto")
    protected String fchVto;
    @XmlElement(name = "FchProceso")
    protected String fchProceso;
    @XmlElement(name = "Observaciones")
    protected ArrayOfObs observaciones;
    @XmlElement(name = "PtoVta")
    protected int ptoVta;
    @XmlElement(name = "CbteTipo")
    protected int cbteTipo;

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Obtiene el valor de la propiedad codAutorizacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAutorizacion() {
        return codAutorizacion;
    }

    /**
     * Define el valor de la propiedad codAutorizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAutorizacion(String value) {
        this.codAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad emisionTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmisionTipo() {
        return emisionTipo;
    }

    /**
     * Define el valor de la propiedad emisionTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmisionTipo(String value) {
        this.emisionTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad fchVto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchVto() {
        return fchVto;
    }

    /**
     * Define el valor de la propiedad fchVto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchVto(String value) {
        this.fchVto = value;
    }

    /**
     * Obtiene el valor de la propiedad fchProceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchProceso() {
        return fchProceso;
    }

    /**
     * Define el valor de la propiedad fchProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchProceso(String value) {
        this.fchProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfObs }
     *     
     */
    public ArrayOfObs getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfObs }
     *     
     */
    public void setObservaciones(ArrayOfObs value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad ptoVta.
     * 
     */
    public int getPtoVta() {
        return ptoVta;
    }

    /**
     * Define el valor de la propiedad ptoVta.
     * 
     */
    public void setPtoVta(int value) {
        this.ptoVta = value;
    }

    /**
     * Obtiene el valor de la propiedad cbteTipo.
     * 
     */
    public int getCbteTipo() {
        return cbteTipo;
    }

    /**
     * Define el valor de la propiedad cbteTipo.
     * 
     */
    public void setCbteTipo(int value) {
        this.cbteTipo = value;
    }

}
