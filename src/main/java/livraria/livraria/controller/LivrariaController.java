package livraria.livraria.controller;

import livraria.livraria.model.Autor;
import livraria.livraria.model.Edicao;
import livraria.livraria.model.Livro;
import livraria.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/livraria")
public class LivrariaController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/livrof")
    public ModelAndView getLivroF() {
        ModelAndView modelAndView = new ModelAndView("livrof");
        modelAndView.addObject("livro",new Livro());
        return modelAndView;
    }
    @GetMapping("/livrot")
    public ModelAndView getLivroT() {
        ModelAndView modelAndView = new ModelAndView("livrot");
        modelAndView.addObject("autor",new Autor());
        return modelAndView;
    }
    @GetMapping("/edicao")
    public ModelAndView edicao() {
        Livro livro = new Livro();
        ModelAndView modelAndView = new ModelAndView("edicao");
        modelAndView.addObject("livro",livro);
        modelAndView.addObject("livros",livroRepository.findAll() );
        return modelAndView;
    }
}

