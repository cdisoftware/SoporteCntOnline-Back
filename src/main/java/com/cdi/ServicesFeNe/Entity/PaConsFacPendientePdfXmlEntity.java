package com.cdi.ServicesFeNe.Entity;

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
    private Integer IdFactura;

    @JsonProperty("NumeroFactura")
    private String NumeroFactura;

    @JsonProperty("NitEmpresa")
    private String NitEmpresa;

    @JsonProperty("NombreEmpresa")
    private String NombreEmpresa;

    @JsonProperty("NitCliente")
    private String NitCliente;

    @JsonProperty("MailCliente")
    private String MailCliente;

    @JsonProperty("FechaGenerada")
    private String FechaGenerada;

    @JsonProperty("CUFE")
    private String CUFE;

    @JsonProperty("Estado")
    private String Estado;

    @JsonProperty("GenDoc")
    private String GenDoc;

    @JsonProperty("UrlPdf")
    private String UrlPdf;

    @JsonProperty("UrlXml")
    private String UrlXml;
}
