//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.05.05 a las 12:50:51 PM ART 
//


package utils.afip.wsfe.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfOpcionalTipo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOpcionalTipo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OpcionalTipo" type="{http://ar.gov.afip.dif.FEV1/}OpcionalTipo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOpcionalTipo", propOrder = {
    "opcionalTipo"
})
public class ArrayOfOpcionalTipo {

    @XmlElement(name = "OpcionalTipo", nillable = true)
    protected List<OpcionalTipo> opcionalTipo;

    /**
     * Gets the value of the opcionalTipo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opcionalTipo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpcionalTipo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpcionalTipo }
     * 
     * 
     */
    public List<OpcionalTipo> getOpcionalTipo() {
        if (opcionalTipo == null) {
            opcionalTipo = new ArrayList<OpcionalTipo>();
        }
        return this.opcionalTipo;
    }

}
