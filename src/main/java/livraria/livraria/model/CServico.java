package livraria.livraria.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cServico")
@XmlType(propOrder = {
        "codigo",
        "valor",
        "prazoEntrega",
        "valorMaoPropria",
        "valorAvisoRecebimento",
        "valorValorDeclarado",
        "entregaDomiciliar",
        "entregaSabado",
        "erro",
        "msgErro",
        "valorSemAdicionais",
        "obsFim"

})
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CServico {
    private int codigo;
    private Double valor;
    private String prazoEntrega;
    private Double valorMaoPropria;
    private Double valorAvisoRecebimento;
    private Double valorValorDeclarado;
    private String entregaDomiciliar;
    private String entregaSabado;
    private int erro;
    private String msgErro;
    private Double valorSemAdicionais;
    private String obsFim;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public Double getValorMaoPropria() {
        return valorMaoPropria;
    }

    public void setValorMaoPropria(Double valorMaoPropria) {
        this.valorMaoPropria = valorMaoPropria;
    }

    public Double getValorAvisoRecebimento() {
        return valorAvisoRecebimento;
    }

    public void setValorAvisoRecebimento(Double valorAvisoRecebimento) {
        this.valorAvisoRecebimento = valorAvisoRecebimento;
    }

    public Double getValorValorDeclarado() {
        return valorValorDeclarado;
    }

    public void setValorValorDeclarado(Double valorValorDeclarado) {
        this.valorValorDeclarado = valorValorDeclarado;
    }

    public String getEntregaDomiciliar() {
        return entregaDomiciliar;
    }

    public void setEntregaDomiciliar(String entregaDomiciliar) {
        this.entregaDomiciliar = entregaDomiciliar;
    }

    public String getEntregaSabado() {
        return entregaSabado;
    }

    public void setEntregaSabado(String entregaSabado) {
        this.entregaSabado = entregaSabado;
    }

    public int getErro() {
        return erro;
    }

    public void setErro(int erro) {
        this.erro = erro;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public Double getValorSemAdicionais() {
        return valorSemAdicionais;
    }

    public void setValorSemAdicionais(Double valorSemAdicionais) {
        this.valorSemAdicionais = valorSemAdicionais;
    }

    public String getObsFim() {
        return obsFim;
    }

    public void setObsFim(String obsFim) {
        this.obsFim = obsFim;
    }

    @Override
    public String toString() {
        return "CServico{" +
                "codigo=" + codigo +
                ", valor=" + valor +
                ", prazoEntrega='" + prazoEntrega + '\'' +
                ", valorMaoPropria=" + valorMaoPropria +
                ", valorAvisoRecebimento=" + valorAvisoRecebimento +
                ", valorValorDeclarado=" + valorValorDeclarado +
                ", entregaDomiciliar='" + entregaDomiciliar + '\'' +
                ", entregaSabado='" + entregaSabado + '\'' +
                ", erro=" + erro +
                ", msgErro='" + msgErro + '\'' +
                ", valorSemAdicionais=" + valorSemAdicionais +
                ", obsFim='" + obsFim + '\'' +
                '}';
    }
}
