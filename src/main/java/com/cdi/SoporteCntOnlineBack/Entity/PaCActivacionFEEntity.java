package com.cdi.SoporteCntOnlineBack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import lombok.Data;

@Entity
@Data
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "PaCActivacionFE",
            procedureName = "PaCActivacionFE",
            parameters = {
                @StoredProcedureParameter(name = "Respuesta",
                        mode = ParameterMode.OUT,
                        type = String.class)
            })
})
public class PaCActivacionFEEntity {
    @Id
    @JsonProperty("NumResolucion")
    public String NumResolucion;
    
    @JsonProperty("Usuario")
    public String Usuario;
    
    @JsonProperty("Contrasena")
    public String Contrasena;
    
    @JsonProperty("Prefijo")
    public String Prefijo;
    
    @JsonProperty("RangoD")
    public String RangoD;
    
    @JsonProperty("RangoH")
    public String RangoH;
    
    @JsonProperty("RangoFecIni")
    public String RangoFecIni;
    
    @JsonProperty("RangoFecFin")
    public String RangoFecFin;
    
    @JsonProperty("PrefijoNC")
    public String PrefijoNC;
    
    @JsonProperty("RangoNCD")
    public String RangoNCD;
    
    @JsonProperty("RangoNCH")
    public String RangoNCH;
    
    @JsonProperty("Nit")
    public String Nit;
}