package livraria.livraria.model;

import javax.xml.bind.annotation.*;
import java.util.List;

//@XmlRootElement(name= "CalcPrecoPrazoResponse")
@XmlRootElement(name = "CalcPrecoPrazoResponse", namespace = "http://tempuri.org/" )
//@XmlAccessorType(XmlAccessType.FIELD) field usa com o propOrder
//@XmlType(propOrder = {
//        "codigo",
//        "valor",
//        "prazoEntrega",
//        "valorMaoPropria",
//        "valorAvisoRecebimento",
//        "valorValorDeclarado",
//        "entregaDomiciliar",
//        "entregaSabado",
//        "erro",
//        "msgErro",
//        "valorSemAdicionais",
//        "obsFim"
//
//})
public class CalcPrecoPrazoResponse {

    @XmlElementWrapper(name = "servicos")
    @XmlElement(name = "cServico")
    private CServico servicos;

    public CServico getServicos() {
        return servicos;
    }

    public void setServicos(CServico servicos) {
        this.servicos = servicos;
    }
}
