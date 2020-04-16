package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Editora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String celular;

    @OneToMany(mappedBy = "editora")
    private List<Edicao> edicoes;
}
