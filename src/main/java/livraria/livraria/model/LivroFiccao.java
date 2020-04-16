package livraria.livraria.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
//@DiscriminatorValue("2")  valor pra diferenciar os livros, declarado na super classe
public class LivroFiccao extends Livro implements Serializable {

    private String genero;
}
