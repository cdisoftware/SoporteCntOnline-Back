package InvocaWSDL;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class Config {
    @Bean
    public Jaxb2Marshaller marshaller(String ContextPath) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(ContextPath);
        return marshaller;
    }

    @Bean
    public SOAPConnectorFacturacion soapConnector(Jaxb2Marshaller marshaller, String DefaultUri) {
        SOAPConnectorFacturacion client = new SOAPConnectorFacturacion();
        client.setDefaultUri(DefaultUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
