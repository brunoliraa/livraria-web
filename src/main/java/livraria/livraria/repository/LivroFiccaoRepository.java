package livraria.livraria.repository;

import livraria.livraria.model.LivroFiccao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LivroFiccaoRepository extends LivroBaseRepository<LivroFiccao> {
}
