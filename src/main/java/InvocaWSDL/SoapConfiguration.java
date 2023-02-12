package InvocaWSDL;

import com.cdi.SoporteCntOnlineBack.ServicesImplementacion.GenerarXMLServiceImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {
    @Autowired
    private GenerarXMLServiceImplementacion client;
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.tempuri");
        return marshaller;
    }

    @Bean
    public GenerarXMLServiceImplementacion soapClient(Jaxb2Marshaller marshaller) {
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
