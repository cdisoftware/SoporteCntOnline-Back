package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import InvocaWSDL.Config;
import InvocaWSDL.SOAPConnectorFacturacion;
import WSDLNE.org.tempuri.GenerarXmlNom;
import WSDLNE.org.tempuri.GenerarXmlNomResponse;
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXmlNeEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXmlNeService;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

@Service
public class GenerarXmlNeServiceImplementacion implements GenerarXmlNeService {

    String Respuesta = "";

    @Override
    public String GenXmlNe(GenerarXmlNeEntity entidad) {
        try {
            Config conf = new Config();

            Jaxb2Marshaller march;
            SOAPConnectorFacturacion conectsoap;

            march = conf.marshaller("WSDLNE.org.tempuri");
            conectsoap = conf.soapConnector(march, "https://api.apptotrip.com/NE_WS/wsNE.asmx");

            GenerarXmlNom request = new GenerarXmlNom();
            request.setPrefijo("ne");
            request.setRegional(entidad.getRegional());
            request.setFechaI(entidad.getFechaI());
            request.setFechaF(entidad.getFechaF());

            GenerarXmlNomResponse response = (GenerarXmlNomResponse) conectsoap.callWebService("http://tempuri.org/GenerarXmlNom", request);

            Respuesta = response.getGenerarXmlNomResult().toString();
            return Respuesta;
        } catch (Exception e) {
            Respuesta = e.getMessage();

            return Respuesta;
        }
    }

}
