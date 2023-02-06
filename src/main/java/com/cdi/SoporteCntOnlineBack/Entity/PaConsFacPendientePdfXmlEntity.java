package com.cdi.SoporteCntOnlineBack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import lombok.Data;

@Entity
@Data
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "PaConsFacPendientePdfXml",
            procedureName = "PaConsFacPendientePdfXml",
            resultClasses = PaConsFacPendientePdfXmlEntity.class)
})
public class PaConsFacPendientePdfXmlEntity {

    @Id
    @JsonProperty("IdFactura")
    public Integer IdFactura;

    @JsonProperty("NumeroFactura")
    public String NumeroFactura;

    @JsonProperty("NitEmpresa")
    public String NitEmpresa;

    @JsonProperty("NombreEmpresa")
    public String NombreEmpresa;

    @JsonProperty("NitCliente")
    public String NitCliente;

    @JsonProperty("MailCliente")
    public String MailCliente;

    @JsonProperty("FechaGenerada")
    public String FechaGenerada;

    @JsonProperty("CUFE")
    public String CUFE;

    @JsonProperty("Estado")
    public String Estado;

    @JsonProperty("GenDoc")
    public String GenDoc;

    @JsonProperty("UrlPdf")
    public String UrlPdf;

    @JsonProperty("UrlXml")
    public String UrlXml;
}
