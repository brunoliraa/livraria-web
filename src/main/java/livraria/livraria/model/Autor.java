package livraria.livraria.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Autor extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String biografia;
    private String dataNascimento;
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
