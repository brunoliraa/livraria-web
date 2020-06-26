package livraria.livraria.service;

import livraria.livraria.model.CServico;
import livraria.livraria.model.CalcPrecoPrazoResult;
import livraria.livraria.model.Servicos;
import livraria.livraria.soap.CalcPrecoPrazoResponse;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class ConvertXmlToJavaObject {

//    JAXBContext jaxbContext;

    public livraria.livraria.model.CalcPrecoPrazoResponse convert (CalcPrecoPrazoResponse xml){
        try{
            //convertendo objeto para xml string
            JAXBContext jaxbContext = JAXBContext.newInstance(CalcPrecoPrazoResponse.class);
//            JAXBContext jaxbContext = JAXBContext.newInstance(Servicos.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(xml, sw);
            String xmlString = sw.toString();

            //convertendo xml para objeto servico
//            String xmlString = String.valueOf(xml);

            System.out.println(xmlString);
            JAXBContext jaxbContext1 = JAXBContext.newInstance(livraria.livraria.model.CalcPrecoPrazoResponse.class);
//            jaxbContext = JAXBContext.newInstance(CServico.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext1.createUnmarshaller();
            livraria.livraria.model.CalcPrecoPrazoResponse servicos = (livraria.livraria.model.CalcPrecoPrazoResponse) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
            System.out.println(servicos);
            return servicos;
        }catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
