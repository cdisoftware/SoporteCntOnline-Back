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
            name = "PaCpaisesFacturacion",
            procedureName = "PaCpaisesFacturacion",
            resultClasses = PaCpaisesFacturacionEntity.class)
})
public class PaCpaisesFacturacionEntity {
    @Id
    @JsonProperty("CodPais")
    public String CodPais;
    
    @JsonProperty("NombrePais")
    public String NombrePais;
}
