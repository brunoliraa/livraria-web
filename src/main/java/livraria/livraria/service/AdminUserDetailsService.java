package livraria.livraria.service;

import livraria.livraria.model.Admin;
import livraria.livraria.model.Cliente;
import livraria.livraria.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Admin admin = Optional.ofNullable(adminRepository.findAdminByLogin(login))
                .orElseThrow(()->new UsernameNotFoundException("admin nao encontrado"));

        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN");

        return new org.springframework.security
                .core.userdetails.User(admin.getLogin(), admin.getSenha(),
                authorityListAdmin);
    }
}
