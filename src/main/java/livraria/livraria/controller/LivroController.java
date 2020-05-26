package livraria.livraria.controller;

import livraria.livraria.model.Autor;
import livraria.livraria.model.Livro;
import livraria.livraria.model.LivroFiccao;
import livraria.livraria.model.LivroTecnico;
import livraria.livraria.repository.LivroRepository;
import livraria.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroService livroService;

    @GetMapping("/all/{imagem}")
    @ResponseBody
    public byte[] findAll(@PathVariable String imagem){
        return livroService.findAll(imagem);
    }

    @PostMapping("/ficcao")
    public ModelAndView saveLivroFiccao(@Valid LivroFiccao livro, BindingResult result){
        return livroService.saveLivro(livro, result);
    }
    @PostMapping("/tecnico")
    public ModelAndView saveLivroTecnico(@Valid LivroTecnico livro, BindingResult result
            , RedirectAttributes attributes){
        return livroService.saveLivro(livro, result);
    }

    @GetMapping("/{id}")
    public ModelAndView findLivroById(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    @DeleteMapping("/{id}")
    public ModelAndView deleteLivro(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
