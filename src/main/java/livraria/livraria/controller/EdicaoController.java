package livraria.livraria.controller;

import livraria.livraria.model.Edicao;
import livraria.livraria.model.Livro;
import livraria.livraria.service.EdicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edicao")
public class EdicaoController {

    @Autowired
    private EdicaoService edicaoService;

    @PostMapping
    public ModelAndView saveEdicao(Edicao edicao, Livro livro, @RequestParam("file") MultipartFile[] arquivo){

        return edicaoService.saveLivro(edicao, livro, arquivo);
    }
}
