
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
 *         &lt;element name="Reg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumFac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codVerifica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "reg",
    "numFac",
    "codVerifica"
})
@XmlRootElement(name = "ValidaFacturaAuto")
public class ValidaFacturaAuto {

    @XmlElement(name = "Reg")
    protected String reg;
    @XmlElement(name = "NumFac")
    protected String numFac;
    protected String codVerifica;

    /**
     * Obtiene el valor de la propiedad reg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReg() {
        return reg;
    }

    /**
     * Define el valor de la propiedad reg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReg(String value) {
        this.reg = value;
    }

    /**
     * Obtiene el valor de la propiedad numFac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumFac() {
        return numFac;
    }

    /**
     * Define el valor de la propiedad numFac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumFac(String value) {
        this.numFac = value;
    }

    /**
     * Obtiene el valor de la propiedad codVerifica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVerifica() {
        return codVerifica;
    }

    /**
     * Define el valor de la propiedad codVerifica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVerifica(String value) {
        this.codVerifica = value;
    }

}
