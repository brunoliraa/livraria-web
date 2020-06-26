package livraria.livraria.controller;

import livraria.livraria.model.Autor;
import livraria.livraria.model.Edicao;
import livraria.livraria.model.Editora;
import livraria.livraria.model.Livro;
import livraria.livraria.repository.EdicaoRepository;
import livraria.livraria.repository.EditoraRepository;
import livraria.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class LivrariaController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private EdicaoRepository edicaoRepository;
    @Autowired
    private EditoraRepository editoraRepository;


    @GetMapping
    public String getIndex() {
        return "index";
    }
    @GetMapping("/livraria")
    public String getHomeAdmin() {
        return "admin/home";
    }


    @GetMapping("/livrof")
    public ModelAndView getLivroF() {
        ModelAndView modelAndView = new ModelAndView("admin/livroficcao");
        modelAndView.addObject("livro",new Livro());
        return modelAndView;
    }
    @GetMapping("/livrot")
    public ModelAndView getLivroT() {
        ModelAndView modelAndView = new ModelAndView("admin/livrotecnico");
        modelAndView.addObject("autor",new Autor());
        return modelAndView;
    }
    @GetMapping("/edicao")
    public ModelAndView edicao() {
        Livro livro = new Livro();
        Editora editora = new Editora();
        ModelAndView modelAndView = new ModelAndView("admin/edicao");
        modelAndView.addObject("livro",livro);
        modelAndView.addObject("editora", editora);
        modelAndView.addObject("editoras", editoraRepository.findAll());
        modelAndView.addObject("livros",livroRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("edicoes",edicaoRepository.findAll());
        return modelAndView;
    }
}

