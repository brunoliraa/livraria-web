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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListaServicosSTARResult" type="{http://tempuri.org/}cResultadoServicos"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listaServicosSTARResult"
})
@XmlRootElement(name = "ListaServicosSTARResponse")
public class ListaServicosSTARResponse {

    @XmlElement(name = "ListaServicosSTARResult", required = true)
    protected CResultadoServicos listaServicosSTARResult;

    /**
     * Obtém o valor da propriedade listaServicosSTARResult.
     * 
     * @return
     *     possible object is
     *     {@link CResultadoServicos }
     *     
     */
    public CResultadoServicos getListaServicosSTARResult() {
        return listaServicosSTARResult;
    }

    /**
     * Define o valor da propriedade listaServicosSTARResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CResultadoServicos }
     *     
     */
    public void setListaServicosSTARResult(CResultadoServicos value) {
        this.listaServicosSTARResult = value;
    }

}
