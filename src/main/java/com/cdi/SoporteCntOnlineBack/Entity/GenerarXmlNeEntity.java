package com.cdi.SoporteCntOnlineBack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GenerarXmlNeEntity {

    @Id
    @JsonProperty("Regional")
    public String Regional;

    @JsonProperty("FechaI")
    public String FechaI;

    @JsonProperty("FechaF")
    public String FechaF;
}
