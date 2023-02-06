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
            name = "PaCActivacionNE",
            procedureName = "PaCActivacionNE",
            parameters = {
                @StoredProcedureParameter(name = "Respuesta",
                        mode = ParameterMode.OUT,
                        type = String.class)
            })
})
public class PaCActivacionNEEntity {
    
    @JsonProperty("PrefijoNE")
    public String PrefijoNE;
    
    @JsonProperty("RangoNED")
    public String RangoNED;
    
    @JsonProperty("RangoNEH")
    public String RangoNEH;
    
    @JsonProperty("ContrasenaNE")
    public String ContrasenaNE;
    
    @JsonProperty("PrefijoNA")
    public String PrefijoNA;
    
    @Id
    @JsonProperty("Nit")
    public String Nit;
}