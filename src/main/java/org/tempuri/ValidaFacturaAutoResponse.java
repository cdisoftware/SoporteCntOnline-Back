
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ValidaFacturaAutoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "validaFacturaAutoResult"
})
@XmlRootElement(name = "ValidaFacturaAutoResponse")
public class ValidaFacturaAutoResponse {

    @XmlElement(name = "ValidaFacturaAutoResult")
    protected String validaFacturaAutoResult;

    /**
     * Obtiene el valor de la propiedad validaFacturaAutoResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidaFacturaAutoResult() {
        return validaFacturaAutoResult;
    }

    /**
     * Define el valor de la propiedad validaFacturaAutoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidaFacturaAutoResult(String value) {
        this.validaFacturaAutoResult = value;
    }

}
