package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String funcao;
    @Column(unique = true)
    private String login;
    private String senha;


}
