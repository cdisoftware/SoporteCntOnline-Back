package com.cdi.SoporteCntOnlineBack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GenerarXmlDsEntity {
    @Id
    @JsonProperty("regional")
    public String regional;

    @JsonProperty("folio")
    public String folio;

    @JsonProperty("prefijo")
    public String prefijo;
}
