package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import InvocaWSDL.Config;
import InvocaWSDL.SOAPConnectorFacturacion;
import WSDLFE.org.tempuri.GenerarXMLFacturacion;
import WSDLFE.org.tempuri.GenerarXMLFacturacionResponse;
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXmlFeEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXmlFeService;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

@Service
public class GenerarXmlFeServiceImplementacion implements GenerarXmlFeService {

    String Respuesta = "";

    @Override
    public String GenXmlFe(GenerarXmlFeEntity entidad) {
        try {
            Config conf = new Config();

            Jaxb2Marshaller march;
            SOAPConnectorFacturacion conectsoap;

            march = conf.marshaller("WSDLFE.org.tempuri");
            conectsoap = conf.soapConnector(march, "http://api.apptotrip.com/FE_WS_FT/wsCOLFE_FT.asmx");

            GenerarXMLFacturacion request = new GenerarXMLFacturacion();
            request.setReg(entidad.getReg());
            request.setNumFac(entidad.getNumFac());
            request.setTipo(entidad.getTipo());
            request.setPrefijo(entidad.getPrefijo());

            GenerarXMLFacturacionResponse response = (GenerarXMLFacturacionResponse) conectsoap.callWebService("http://tempuri.org/GenerarXMLFacturacion", request);

            Respuesta = response.getGenerarXMLFacturacionResult().toString();
            return Respuesta;
        } catch (Exception e) {
            //Respuesta = "No se pudo obtener el recurso.";
            Respuesta = e.getMessage().toString();
            return Respuesta;
        }
    }
}
