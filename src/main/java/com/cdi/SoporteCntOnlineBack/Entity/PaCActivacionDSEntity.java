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
            name = "PaCActivacionDS",
            procedureName = "PaCActivacionDS",
            parameters = {
                @StoredProcedureParameter(name = "Respuesta",
                        mode = ParameterMode.OUT,
                        type = String.class)
            })
})
public class PaCActivacionDSEntity {
    @Id
    @JsonProperty("Nit")
    public String Nit;
    
    @JsonProperty("NumResolucionDS")
    public String NumResolucionDS;
    
    @JsonProperty("PrefijoDS")
    public String PrefijoDS;
    
    @JsonProperty("RangoDS_D")
    public String RangoDS_D;
    
    @JsonProperty("RangoDS_H")
    public String RangoDS_H;
    
    @JsonProperty("FechaInicioDS")
    public String FechaInicioDS;
    
    @JsonProperty("FechaFinDS")
    public String FechaFinDS;
}
