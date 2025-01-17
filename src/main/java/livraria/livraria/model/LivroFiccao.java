package livraria.livraria.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
//@DiscriminatorValue("2")  valor pra diferenciar os livros, declarado na super classe
public class LivroFiccao extends Livro implements Serializable {

    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LivroFiccao{" +super.getTitulo()+
                " genero='" + genero + '\'' +
                '}';
    }
}
