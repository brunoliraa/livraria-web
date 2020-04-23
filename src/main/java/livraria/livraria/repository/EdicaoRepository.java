package livraria.livraria.repository;

import livraria.livraria.model.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
    Edicao findEdicaoById(Long id);
}
