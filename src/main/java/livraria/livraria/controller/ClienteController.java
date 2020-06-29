package livraria.livraria.controller;

import livraria.livraria.model.Cliente;
import livraria.livraria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView clienteCadastro(){
        ModelAndView modelAndView = new ModelAndView("cliente/cliente");
        Cliente cliente = new Cliente();
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView saveCliente(Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

}
