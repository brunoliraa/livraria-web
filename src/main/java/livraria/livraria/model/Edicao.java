package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Edicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate ano;
    private int numero;
    private BigDecimal valor;
    private int estoque;
    private int numPaginas;
    private String isbn;
    private boolean disponivel = false;

    @ManyToOne
    @JoinColumn(name = "livro_id") // porque é nessa tabela que vai ter a chave estrangeira que referencia Livro
    private Livro livro;

    @ManyToOne //Uma editora pode publicar muitas edições
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany(mappedBy = "edicoes")
    private List<Venda> vendas;
}
