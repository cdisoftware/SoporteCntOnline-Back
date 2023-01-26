package com.cdi.ServicesFeNe.ServicesImplementacion;

import com.cdi.ServicesFeNe.Entity.EnvioSmsItCloudEntity;
import com.cdi.ServicesFeNe.Services.EnvioSmsItCloudServices;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnvioSmsItCloudServicesImplemtacion implements EnvioSmsItCloudServices {

    String Respuesta;

    @Override
    public String EnvioSms(EnvioSmsItCloudEntity entidad) {

        try {
            RestTemplate rt = new RestTemplate();
            ResponseEntity<String> response = rt.exchange("https://contacto-masivo.com/sms/back_sms/public/api/sendsms?user=" + entidad.getUser() + "&token=" + entidad.getToken() + "&GSM=" + entidad.getGSM() + "&SMSText=" + entidad.getSMSText() + "&metodo_envio=" + entidad.getMetodo_envio(), HttpMethod.POST, null, String.class);
            Respuesta = response.toString();
        } catch (Exception ex) {
            return "Error:" + ex.getMessage();
        }
        return Respuesta;
    }

}