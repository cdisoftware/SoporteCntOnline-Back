package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.GenerarXMLEntity;
import com.cdi.SoporteCntOnlineBack.Services.GenerarXMLService;
import org.springframework.stereotype.Service;
import org.tempuri.GenerarXMLFacturacion;
import org.tempuri.GenerarXMLFacturacionResponse;

@Service
public class GenerarXMLServiceImplementacion implements GenerarXMLService{

    String Respuesta;
    
    GenerarXMLFacturacion wsdlGenerarXMLFacturacion;
    
    GenerarXMLFacturacionResponse WSDLGenerarXMLFacturacionResponse;
    
    
    @Override
    public String GneraXMLFE(GenerarXMLEntity entidad) {
        try {
            Object xml = entidad;
            
            WSDLGenerarXMLFacturacionResponse.getClass();
            wsdlGenerarXMLFacturacion.equals(xml);
        } catch (Exception ex) {
            return Respuesta = "Error:" + ex.getMessage();
        }
        return null;
    }
    
}
