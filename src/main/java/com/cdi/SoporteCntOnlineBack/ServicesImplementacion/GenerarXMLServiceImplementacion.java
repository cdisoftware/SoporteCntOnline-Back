package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import InvocaWSDL.SOAPConnectClient;
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXMLEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXMLService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.tempuri.GenerarXMLFacturacion;
import org.tempuri.GenerarXMLFacturacionResponse;

@Service
public class GenerarXMLServiceImplementacion implements GenerarXMLService {

    String Respuesta;

    @Autowired
    private SOAPConnectClient Cliente;

    @Value("${WSDL.SOAPClient}")
    private String clientEndPoint;

    @Autowired
    Jaxb2Marshaller marshaller;

    @Bean
    public Jaxb2Marshaller marshallerMtd() {
        Jaxb2Marshaller marsh = new Jaxb2Marshaller();
        marsh.setContextPath("org.tempuri");
        return marsh;
    }

    @Bean
    public SOAPConnectClient soap(Jaxb2Marshaller marshaller) {
        SOAPConnectClient client = new SOAPConnectClient();
        client.setDefaultUri(clientEndPoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Override
    public String GneraXMLFE(GenerarXMLEntity entidad) {
        try {
            marshaller = marshallerMtd();
            Cliente = soap(marshaller);

            GenerarXMLFacturacion request = new GenerarXMLFacturacion();
            request.setReg(entidad.getReg());
            request.setNumFac(entidad.getNumFac());
            request.setTipo(entidad.getTipo());
            request.setPrefijo(entidad.getPrefijo());

            GenerarXMLFacturacionResponse respu = (GenerarXMLFacturacionResponse) Cliente.callWebServices(clientEndPoint, request);

            return Respuesta = "Siiiiiiii";
        } catch (Exception ex) {
            return Respuesta = "Error:" + ex.getMessage();
        }
    }

}
