package InvocaWSDL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
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
}
