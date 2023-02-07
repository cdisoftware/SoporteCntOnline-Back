package com.cdi.SoporteCntOnlineBack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GenerarXMLEntity implements Serializable {
    @Id
    @JsonProperty("Reg")
    public String Reg;
    
    @JsonProperty("NumFac")
    public String NumFac;
    
    @JsonProperty("Tipo")
    public String Tipo;
    
    @JsonProperty("Prefijo")
    public String Prefijo;
}
