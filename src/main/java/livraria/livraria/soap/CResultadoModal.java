//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.04.28 às 09:47:08 AM BRT 
//


package livraria.livraria.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cResultadoModal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cResultadoModal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServicosModal" type="{http://tempuri.org/}ArrayOfCModal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cResultadoModal", propOrder = {
    "servicosModal"
})
public class CResultadoModal {

    @XmlElement(name = "ServicosModal")
    protected ArrayOfCModal servicosModal;

    /**
     * Obtém o valor da propriedade servicosModal.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCModal }
     *     
     */
    public ArrayOfCModal getServicosModal() {
        return servicosModal;
    }

    /**
     * Define o valor da propriedade servicosModal.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCModal }
     *     
     */
    public void setServicosModal(ArrayOfCModal value) {
        this.servicosModal = value;
    }

}
