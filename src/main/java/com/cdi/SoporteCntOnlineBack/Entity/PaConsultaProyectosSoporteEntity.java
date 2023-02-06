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
            name = "PaConsultaProyectosSoporte",
            procedureName = "PaConsultaProyectosSoporte",
            resultClasses = PaConsultaProyectosSoporteEntity.class)
})
public class PaConsultaProyectosSoporteEntity {
    @Id
    @JsonProperty("IdProyecto")
    public Integer IdProyecto;

    @JsonProperty("Proyecto")
    public String Proyecto;

    @JsonProperty("Imagen")
    public String Imagen;
    
    @JsonProperty("urlComponente")
    public String urlComponente;
}
