package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "livro")
@Inheritance(strategy = InheritanceType.JOINED)
/*aqui nós diferenciamos as subclasses de livro por uma coluna de integer chamada livro_tipo
apenas no modo single table */
//@DiscriminatorColumn(name = "livro_tipo",discriminatorType = DiscriminatorType.INTEGER)
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private LocalDate anoPublicacao;
    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores;

    @OneToMany(mappedBy = "livro")// pro jpa saber onde ta a chave estrangeira(joinColumn), nome do atributo
    private List<Edicao> edicoes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
