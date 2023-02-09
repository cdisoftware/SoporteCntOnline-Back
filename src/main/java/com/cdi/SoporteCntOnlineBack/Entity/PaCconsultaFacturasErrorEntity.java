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
            name = "PaCconsultaFacturasError",
            procedureName = "PaCconsultaFacturasError",
            resultClasses = PaCconsultaFacturasErrorEntity.class)
})
public class PaCconsultaFacturasErrorEntity {

    @Id
    @JsonProperty("NumeroFactura")
    public String NumeroFactura;
    
    @JsonProperty("IdCol")
    public String IdCol;
    
    @JsonProperty("Nombre")
    public String Nombre;

    @JsonProperty("Prefijo")
    public String Prefijo;

    @JsonProperty("NitEmpresa")
    public String NitEmpresa;

    @JsonProperty("NitCliente")
    public String NitCliente;

    @JsonProperty("MailCliente")
    public String MailCliente;

    @JsonProperty("NombreCliente")
    public String NombreCliente;

    @JsonProperty("Fecha")
    public String Fecha;

    @JsonProperty("Observaciones")
    public String Observaciones;

    @JsonProperty("Error")
    public String Error;
}
