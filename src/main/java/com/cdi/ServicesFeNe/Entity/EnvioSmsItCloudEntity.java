package com.cdi.ServicesFeNe.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EnvioSmsItCloudEntity implements Serializable{
    @Id
    @JsonProperty("user")
    public String user;
    
    @JsonProperty("token")
    public String token;
    
    @JsonProperty("GSM")
    public String GSM;

    @JsonProperty("SMSText")
    public String SMSText;

    @JsonProperty("metodo_envio")
    public String metodo_envio;
}
