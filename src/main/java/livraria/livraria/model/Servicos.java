package livraria.livraria.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "Servicos")
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorType(XmlAccessType.FIELD)
public class Servicos implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "cservico")
    private CServico servico;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CServico getServico() {
        return servico;
    }

    public void setServico(CServico servico) {
        this.servico = servico;
    }
}
