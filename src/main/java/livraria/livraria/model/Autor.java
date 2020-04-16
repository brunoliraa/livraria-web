package livraria.livraria.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) //não pode ser null
    private String nome;
    private String biografia;
    private String dataNascimento;
    @ManyToMany(cascade = CascadeType.ALL)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "autor_livro",joinColumns = @JoinColumn(name = "autor_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "livro_id",referencedColumnName ="id"))
    private List<Livro> livros;

}
