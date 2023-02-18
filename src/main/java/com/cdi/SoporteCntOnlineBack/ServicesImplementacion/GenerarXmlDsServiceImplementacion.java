package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import InvocaWSDL.Config;
import InvocaWSDL.SOAPConnectorFacturacion;
import WSDLDS.org.tempuri.GenXML;
import WSDLDS.org.tempuri.GenXMLResponse;
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXmlDsEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXmlDsService;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

@Service
public class GenerarXmlDsServiceImplementacion implements GenerarXmlDsService{

    String Respuesta = "";
    
    @Override
    public String GenXmlDs(GenerarXmlDsEntity entidad) {
        try {
            Config conf = new Config();

            Jaxb2Marshaller march;
            SOAPConnectorFacturacion conectsoap;

            march = conf.marshaller("WSDLDS.org.tempuri");
            conectsoap = conf.soapConnector(march, "http://api.apptotrip.com/DS_WS/wsDS.asmx");

            GenXML request = new GenXML();
            request.setRegional(entidad.getRegional());
            request.setFolio(entidad.getFolio());
            request.setPrefijo(entidad.getPrefijo());
            GenXMLResponse response = (GenXMLResponse) conectsoap.callWebService("http://tempuri.org/GenXML", request);

            Respuesta = response.getGenXMLResult().toString();
            return Respuesta;
        } catch (Exception e) {
            //Respuesta = "No se pudo obtener el recurso.";
            Respuesta = e.getMessage().toString();
            return Respuesta;
        }
    }
    
}
