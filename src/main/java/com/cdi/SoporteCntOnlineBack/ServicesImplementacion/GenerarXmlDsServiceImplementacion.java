package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import InvocaWSDL.SOAPConnectorFacturacion;
import WSDLNE.org.tempuri.GenerarXmlNom;
import WSDLNE.org.tempuri.GenerarXmlNomResponse;
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXmlDsEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXmlDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

@Service
public class GenerarXmlDsServiceImplementacion implements GenerarXmlDsService{

    String Respuesta = "";
    
    @Autowired
    Jaxb2Marshaller march;

    @Autowired
    SOAPConnectorFacturacion conectsoap;
    

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.tempuri");
        return marshaller;
    }

    @Bean
    public SOAPConnectorFacturacion soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnectorFacturacion client = new SOAPConnectorFacturacion();
        client.setDefaultUri("http://api.apptotrip.com/FE_WS_FT/wsCOLFE_FT.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    
    @Override
    public String GenXmlDs(GenerarXmlDsEntity entidad) {
        try {
            march = marshaller();
            conectsoap = soapConnector(march);

            GenerarXmlNom request = new GenerarXmlNom();
            request.setPrefijo("ne");

            GenerarXmlNomResponse response = (GenerarXmlNomResponse) conectsoap.callWebService("http://tempuri.org/GenerarXMLFacturacion", request);

            Respuesta = response.getGenerarXmlNomResult().toString();
            return Respuesta;
        } catch (Exception e) {
            Respuesta = "No se pudo obtener el recurso.";

            return Respuesta;
        }
    }
    
}
