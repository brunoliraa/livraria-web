package livraria.livraria.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "edicaoVendida")
public class EdicaoVendida {
    /*Tabela entermediária entre Edicao e Venda, foi necessária porque tem atributos de relacionamento
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "venda_id") //nullable =false
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "edicao_id") //nullable =false
    private Edicao edicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
}
