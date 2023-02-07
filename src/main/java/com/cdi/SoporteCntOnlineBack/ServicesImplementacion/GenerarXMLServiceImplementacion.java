package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.GenerarXMLEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXMLService;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenerarXMLServiceImplementacion implements GenerarXMLService{

    String Respuesta;
    
    @Override
    public String GneraXMLFE(GenerarXMLEntity entidad) {
        try {
            RestTemplate rt = new RestTemplate();
            //ResponseEntity<String> respu = rt.exchange("https://contacto-masivo.com/sms/back_sms/public/api/sendsms?user=" + entidad.getUser() + "&token=" + entidad.getToken() + "&GSM=" + entidad.getGSM() + "&SMSText=" + entidad.getSMSText() + "&metodo_envio=" + entidad.getMetodo_envio(), HttpMethod.POST, null, String.class);
            return Respuesta = "";
        } catch (Exception ex) {
            return Respuesta = "Error:" + ex.getMessage();
        }
    }
    
}
