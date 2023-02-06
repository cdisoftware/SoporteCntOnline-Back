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
            name = "ConsultaInfoUser",
            procedureName = "ConsultaInfoUser",
            resultClasses = ConsultaInfoUserEntity.class)
})
public class ConsultaInfoUserEntity {
   @Id
    @JsonProperty("IdUser")
    public Integer IdUser;
   
   @JsonProperty("Nombre")
    public String Nombre;
   
   @JsonProperty("Apellido")
    public String Apellido;
   
   @JsonProperty("Usuario")
    public String Usuario;
   
   @JsonProperty("Pasword")
    public String Pasword;
   
   @JsonProperty("Novedad")
    public String Novedad;
}
