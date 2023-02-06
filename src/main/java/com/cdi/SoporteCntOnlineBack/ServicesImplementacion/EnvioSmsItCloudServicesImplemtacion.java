package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.EnvioSmsItCloudEntity;
import com.cdi.SoporteCntOnlineBack.Services.EnvioSmsItCloudServices;
import org.json.JSONObject;
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
            Respuesta = JSONObject.quote("SMS Enviado Correctamente");
        } catch (Exception ex) {
            
            return "Error:" + ex.getMessage();
        }
        return Respuesta;
    }

}