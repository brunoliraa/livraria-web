package livraria.livraria.repository;

import livraria.livraria.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository  extends JpaRepository<Editora, Long> {
    Editora findEditoraById(Long id);
}
