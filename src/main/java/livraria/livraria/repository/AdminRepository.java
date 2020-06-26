package livraria.livraria.repository;

import livraria.livraria.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByLogin(String login);

}
