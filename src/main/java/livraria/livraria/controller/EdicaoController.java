package livraria.livraria.controller;

import livraria.livraria.model.Edicao;
import livraria.livraria.service.EdicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edicao")
public class EdicaoController {

    @Autowired
    private EdicaoService edicaoService;

    @PostMapping
    public ModelAndView saveEdicao(Edicao edicao){
        return edicaoService.save(edicao);
    }
}
