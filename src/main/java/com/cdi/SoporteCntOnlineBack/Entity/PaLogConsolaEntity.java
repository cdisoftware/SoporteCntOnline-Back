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
            name = "PaLogConsola",
            procedureName = "PaLogConsola",
            resultClasses = PaLogConsolaEntity.class)
})
public class PaLogConsolaEntity {
    @Id
    @JsonProperty("IdLog")
    public Integer IdLog;
    
    @JsonProperty("Componente")
    public String Componente;
    
    @JsonProperty("Tipo")
    public String Tipo;
    
    @JsonProperty("Mensaje")
    public String Mensaje;
    
    @JsonProperty("Origen")
    public Integer Origen;
    
    @JsonProperty("IdUser")
    public Integer IdUser;
}
