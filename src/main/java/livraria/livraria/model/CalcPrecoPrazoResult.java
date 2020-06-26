package livraria.livraria.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name= "CalcPrecoPrazoResult")
//@XmlRootElement(name = "servicos")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CalcPrecoPrazoResult {

    @XmlElement(name = "servicos")
    private Servicos servicos;

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }
}
