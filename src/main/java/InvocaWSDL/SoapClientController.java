package InvocaWSDL;

import com.cdi.SoporteCntOnlineBack.Entity.GenerarXMLEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genXml")
public class SoapClientController {
    @Autowired
    private SoapClient soapClient;
    
    @PostMapping("/GenXmlFacturacion")
    public String GenXML(
            @RequestBody GenerarXMLEntity entidad) {
        return soapClient.GeneraXml(entidad);
    }
}