package livraria.livraria.repository;

import livraria.livraria.model.Livro;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LivroRepository extends LivroBaseRepository<Livro> {
}
