//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.02.13 a las 02:49:32 PM COT 
//


package org.tempuri;

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
 *         &lt;element name="CreacionNomElectronicaResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "creacionNomElectronicaResult"
})
@XmlRootElement(name = "CreacionNomElectronicaResponse")
public class CreacionNomElectronicaResponse {

    @XmlElement(name = "CreacionNomElectronicaResult")
    protected String creacionNomElectronicaResult;

    /**
     * Obtiene el valor de la propiedad creacionNomElectronicaResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreacionNomElectronicaResult() {
        return creacionNomElectronicaResult;
    }

    /**
     * Define el valor de la propiedad creacionNomElectronicaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreacionNomElectronicaResult(String value) {
        this.creacionNomElectronicaResult = value;
    }

}
