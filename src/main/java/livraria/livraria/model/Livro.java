package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores;

    @OneToMany(mappedBy = "livro")// pro jpa saber onde ta a chave estrangeira(joinColumn), nome do atributo
    private List<Edicao> edicoes;

    @ElementCollection
    @CollectionTable(name = "livro_fotos", joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "fotos")
    private List<String> imagens;

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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Edicao> getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(List<Edicao> edicoes) {
        this.edicoes = edicoes;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", autores=" + autores +
                ", edicoes=" + edicoes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return Objects.equals(getId(), livro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
