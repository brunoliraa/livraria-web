package livraria.livraria.repository;

import livraria.livraria.model.LivroTecnico;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LivroTecnicoRepository extends LivroBaseRepository<LivroTecnico> {
}
