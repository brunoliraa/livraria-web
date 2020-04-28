package livraria.livraria.soapClient;

import livraria.livraria.soap.CalcPrecoPrazo;
import livraria.livraria.soap.CalcPrecoPrazoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
    @Autowired
    private Jaxb2Marshaller marshaller;
    private WebServiceTemplate template;

    public CalcPrecoPrazoResponse callWebService(CalcPrecoPrazo calcPrecoPrazo, String soapAction){
        return (CalcPrecoPrazoResponse) getWebServiceTemplate()
                .marshalSendAndReceive(calcPrecoPrazo,
                        new SoapActionCallback(soapAction));
    }
}
