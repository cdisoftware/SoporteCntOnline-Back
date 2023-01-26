package com.cdi.ServicesFeNe.ServicesImplementacion;

import com.cdi.ServicesFeNe.Entity.EnvioSmsItCloudEntity;
import com.cdi.ServicesFeNe.Services.EnvioSmsItCloudServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class EnvioSmsItCloudServicesImplemtacion implements EnvioSmsItCloudServices {

    @Override
    public String EnvioSms(EnvioSmsItCloudEntity entidad) {

        JSONObject ObjectJson = new JSONObject();

        String var = "";
        try {
            RestTemplate rt = new RestTemplate();
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
            parameters.add("GSM", entidad.getGSM());
            parameters.add("SMSText", entidad.getSMSText());
            parameters.add("metodo_envio", entidad.getMetodo_envio());
            ResponseEntity<Object> response = rt.exchange("https://contacto-masivo.com/sms/back_sms/public/api/sendsms?user=cdiamazonws%40gmail.com&token=x86ad3ce6oprr9b382xma" + "&GSM=" + entidad.getGSM() + "&SMSText=" + entidad.getSMSText() + "&metodo_envio=" + entidad.getMetodo_envio(), HttpMethod.POST, null, Object.class);
            Object NitObject = response.getBody();
            com.fasterxml.jackson.databind.ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(NitObject);
            ObjectJson = new JSONObject(json);
            return JSONObject.quote(NitObject.toString());
        } catch (Exception ex) {
            return "Error:" + ex.getMessage();
        }

    }

}
