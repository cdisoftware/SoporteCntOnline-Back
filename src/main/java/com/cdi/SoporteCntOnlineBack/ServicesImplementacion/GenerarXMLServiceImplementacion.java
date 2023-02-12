package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
/*
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXMLEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tempuri.GenerarXMLFacturacion;
import org.tempuri.GenerarXMLFacturacionResponse;


@Service
@Component("wsCOLFE_FT")*/
public class GenerarXMLServiceImplementacion extends WebServiceGatewaySupport {
/*
    private final String endpoint = "http://api.apptotrip.com/FE_WS_FT/wsCOLFE_FT.asmx?WSDL";
    
    @Autowired
    private Jaxb2Marshaller march;
    @Autowired
    private GenerarXMLServiceImplementacion client;

    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.tempuri");
        return marshaller;
    }

    @Bean
    public GenerarXMLServiceImplementacion soapClient(Jaxb2Marshaller marshaller) {
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    
    public String GneraXMLFE(GenerarXMLEntity entidad) {
        try {
            
            march = marshaller();
            client = soapClient(march);
            
            GenerarXMLFacturacion request = new GenerarXMLFacturacion();
            request.setReg("130");
            request.setNumFac("313");
            request.setTipo("fc");
            request.setPrefijo("FE");
            
            GenerarXMLFacturacionResponse response = (GenerarXMLFacturacionResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
            
            return response.getGenerarXMLFacturacionResult();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    */

}
