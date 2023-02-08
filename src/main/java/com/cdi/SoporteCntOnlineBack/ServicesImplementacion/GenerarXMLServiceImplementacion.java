package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import InvocaWSDL.SOAPConnectClient;
import com.cdi.SoporteCntOnlineBack.Entity.GenerarXMLEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXMLService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.tempuri.GenerarXMLFacturacion;
import org.tempuri.GenerarXMLFacturacionResponse;

@Service
public class GenerarXMLServiceImplementacion implements GenerarXMLService {

    String Respuesta;

    @Autowired
    private SOAPConnectClient client;

    @Value("${WSDL.SOAPClient}")
    private String clientEndPoint;
    
    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    @Before
    public void init() throws Exception{
        marshaller.setPackagesToScan("WSDL.org.tempuri");
        marshaller.afterPropertiesSet();
    }

    @Override
    public String GneraXMLFE(GenerarXMLEntity entidad) {
        try {
            GenerarXMLFacturacion request = new GenerarXMLFacturacion();
            request.setReg("212");
            request.setNumFac("2785");
            request.setTipo("fc");
            request.setPrefijo("FEVC");

            GenerarXMLFacturacionResponse respu = (GenerarXMLFacturacionResponse) client.callWebServices(clientEndPoint, request);
            
            return Respuesta = "Siiiiiiii";
        } catch (Exception ex) {
            return Respuesta = "Error:" + ex.getMessage();
        }
    }

}
