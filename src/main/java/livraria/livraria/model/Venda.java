package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;
    private BigDecimal valorTotal;

    @ManyToMany
    @JoinTable(name = "edicaoVendida",joinColumns = @JoinColumn(name = "venda_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "edicao_id",referencedColumnName ="id"))
    private List<Edicao> edicoes;

}
