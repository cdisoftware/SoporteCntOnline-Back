package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import InvocaWSDL.SOAPConnectorFacturacion;
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXmlFeEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXmlFeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.tempuri.GenerarXMLFacturacion;
import org.tempuri.GenerarXMLFacturacionResponse;

@Service
public class GenerarXmlFeServiceImplementacion implements GenerarXmlFeService {

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
    public String GenXmlFe(GenerarXmlFeEntity entidad) {
        try {
            march = marshaller();
            conectsoap = soapConnector(march);

            System.out.println("Reg " + entidad.getReg());
            System.out.println("NumFac " + entidad.getNumFac());
            System.out.println("Tipo " + entidad.getTipo());
            System.out.println("Prefijo " + entidad.getPrefijo());

            GenerarXMLFacturacion request = new GenerarXMLFacturacion();
            request.setReg(entidad.getReg());
            request.setNumFac(entidad.getNumFac());
            request.setTipo(entidad.getTipo());
            request.setPrefijo(entidad.getPrefijo());

            GenerarXMLFacturacionResponse response = (GenerarXMLFacturacionResponse) conectsoap.callWebService("http://tempuri.org/GenerarXMLFacturacion", request);

            System.out.println("Obtuve la respuesta a continuación ========= : ");
            System.out.println("Resultado : " + response.getGenerarXMLFacturacionResult().toString());

            Respuesta = response.getGenerarXMLFacturacionResult().toString();
            return response.getGenerarXMLFacturacionResult();
        } catch (Exception e) {
            Respuesta = "No se pudo obtener el recurso.";

            return Respuesta;
        }
    }
}
