package livraria.livraria.service;

import livraria.livraria.model.Cliente;
import livraria.livraria.repository.ClienteRepository;
import livraria.livraria.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ClienteService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public ModelAndView saveCliente(Cliente cliente){
        cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
        ModelAndView modelAndView = new ModelAndView("index");
//        cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
        clienteRepository.save(cliente);
//        pessoaRepository.save(cliente);
        modelAndView.addObject("pessoas",pessoaRepository.findAll());
        return modelAndView;
    }

    public Cliente buscarClienteLogado() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder
                        .getContext()
                        .getAuthentication().getPrincipal();
        return clienteRepository.findByEmail(principal.getUsername());
    }
}
