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
            name = "PaCmunicipios",
            procedureName = "PaCmunicipios",
            resultClasses = PaCmunicipiosEntity.class)
})
public class PaCmunicipiosEntity {
    @Id
    @JsonProperty("Id")
    public Integer Id;
    
    @JsonProperty("Codigo")
    public String Codigo;
    
    @JsonProperty("Nombre")
    public String Nombre;
}
