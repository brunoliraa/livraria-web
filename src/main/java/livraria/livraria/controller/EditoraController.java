package livraria.livraria.controller;

import livraria.livraria.model.Editora;
import livraria.livraria.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/livraria")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping("/editora")
    public ModelAndView getEditora(){
        ModelAndView modelAndView = new ModelAndView("editora");
        return modelAndView;
    }

    @PostMapping("/editora")
    public ModelAndView saveEditora(Editora editora){
        ModelAndView modelAndView = new ModelAndView("index");
        editoraRepository.save(editora);
        return modelAndView;
    }
}
