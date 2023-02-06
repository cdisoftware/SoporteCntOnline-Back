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
            name = "PaCdepartamentos",
            procedureName = "PaCdepartamentos",
            resultClasses = PaCdepartamentosEntity.class)
})
public class PaCdepartamentosEntity {
    @Id
    @JsonProperty("Id")
    public Integer Id;
    
    @JsonProperty("CodigoDepartamento")
    public String CodigoDepartamento;
    
    @JsonProperty("Nombre")
    public String Nombre;
    
    @JsonProperty("CodPais")
    public String CodPais;
}
