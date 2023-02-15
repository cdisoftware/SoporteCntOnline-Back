//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.02.15 a las 09:52:03 AM COT 
//


package WSDLDS.org.tempuri;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreacionDocSoporteResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "creacionDocSoporteResult"
})
@XmlRootElement(name = "CreacionDocSoporteResponse")
public class CreacionDocSoporteResponse {

    @XmlElement(name = "CreacionDocSoporteResult")
    protected String creacionDocSoporteResult;

    /**
     * Obtiene el valor de la propiedad creacionDocSoporteResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreacionDocSoporteResult() {
        return creacionDocSoporteResult;
    }

    /**
     * Define el valor de la propiedad creacionDocSoporteResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreacionDocSoporteResult(String value) {
        this.creacionDocSoporteResult = value;
    }

}
