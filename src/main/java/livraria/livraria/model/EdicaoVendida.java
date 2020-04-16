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
}
