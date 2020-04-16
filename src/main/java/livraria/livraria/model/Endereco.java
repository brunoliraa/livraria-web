package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private int numero;

    @OneToOne(mappedBy = "endereco")
    //@JoinColumn(name = "pessoa_id") só precisa ter em uma entidade
    private Pessoa pessoa;

}
