package livraria.livraria.controller;

import livraria.livraria.model.Livro;
import livraria.livraria.model.LivroFiccao;
import livraria.livraria.model.LivroTecnico;
import livraria.livraria.repository.LivroRepository;
import livraria.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<Livro> findAll(){
        return new ResponseEntity(livroRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/ficcao")
    public ModelAndView saveLivroFiccao(LivroFiccao livro, @RequestParam("file") MultipartFile[] arquivo){

        return livroService.saveLivro(livro, arquivo);
    }
    @PostMapping("/tecnico")
    public ModelAndView saveLivroTecnico(LivroTecnico livro){
        ModelAndView modelAndView = new ModelAndView("index");
        livroRepository.save(livro);
        System.out.println(livro);
        return modelAndView;
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
