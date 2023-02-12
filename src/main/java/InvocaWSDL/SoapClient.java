package InvocaWSDL;

import com.cdi.SoporteCntOnlineBack.Entity.GenerarXMLEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.tempuri.GenerarXMLFacturacion;
import org.tempuri.GenerarXMLFacturacionResponse;

@Service
@Component("wsCOLFE_FT")
public class SoapClient extends WebServiceGatewaySupport {

    private final String endpoint = "http://api.apptotrip.com/FE_WS_FT/wsCOLFE_FT.asmx?WSDL";

    public String GeneraXml(GenerarXMLEntity entidad) {
        // Creamos el request
        GenerarXMLFacturacion request = new GenerarXMLFacturacion();
        request.setReg(entidad.getReg());
        request.setNumFac(entidad.getNumFac());
        request.setTipo(entidad.getTipo());
        request.setPrefijo(entidad.getPrefijo());

        // Invocamos el servicio
        GenerarXMLFacturacionResponse response = (GenerarXMLFacturacionResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);

        // Retornamos el dato
        return response.getGenerarXMLFacturacionResult();
    }
}
