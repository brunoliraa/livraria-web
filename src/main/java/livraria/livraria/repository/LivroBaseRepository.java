package livraria.livraria.repository;

import livraria.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean
public interface LivroBaseRepository  <T extends Livro> extends JpaRepository<T, Long> {

}
