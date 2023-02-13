//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.02.13 a las 02:21:39 PM COT 
//


package WSDLNE.org.tempuri;

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
 *         &lt;element name="DescargaPDFResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "descargaPDFResult"
})
@XmlRootElement(name = "DescargaPDFResponse")
public class DescargaPDFResponse {

    @XmlElement(name = "DescargaPDFResult")
    protected String descargaPDFResult;

    /**
     * Obtiene el valor de la propiedad descargaPDFResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescargaPDFResult() {
        return descargaPDFResult;
    }

    /**
     * Define el valor de la propiedad descargaPDFResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescargaPDFResult(String value) {
        this.descargaPDFResult = value;
    }

}
