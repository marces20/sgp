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
 * <p>Clase Java para Comprador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Comprador"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocTipo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DocNro" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Porcentaje" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Comprador", propOrder = {
    "docTipo",
    "docNro",
    "porcentaje"
})
public class Comprador {

    @XmlElement(name = "DocTipo")
    protected int docTipo;
    @XmlElement(name = "DocNro")
    protected long docNro;
    @XmlElement(name = "Porcentaje")
    protected double porcentaje;

    /**
     * Obtiene el valor de la propiedad docTipo.
     * 
     */
    public int getDocTipo() {
        return docTipo;
    }

    /**
     * Define el valor de la propiedad docTipo.
     * 
     */
    public void setDocTipo(int value) {
        this.docTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad docNro.
     * 
     */
    public long getDocNro() {
        return docNro;
    }

    /**
     * Define el valor de la propiedad docNro.
     * 
     */
    public void setDocNro(long value) {
        this.docNro = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentaje.
     * 
     */
    public double getPorcentaje() {
        return porcentaje;
    }

    /**
     * Define el valor de la propiedad porcentaje.
     * 
     */
    public void setPorcentaje(double value) {
        this.porcentaje = value;
    }

}
