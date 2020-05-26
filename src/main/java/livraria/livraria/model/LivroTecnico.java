package livraria.livraria.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
//@DiscriminatorValue("1")  valor pra diferenciar os livros, declarado na super classe
public class LivroTecnico extends Livro implements Serializable {

    private String areaAtuacao;

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public String toString() {
        return "LivroTecnico{" +
                "areaAtuacao='" + areaAtuacao + '\'' +
                '}';
    }
}
