package livraria.livraria.controller;

import livraria.livraria.model.Edicao;
import livraria.livraria.model.Editora;
import livraria.livraria.model.Livro;
import livraria.livraria.repository.EdicaoRepository;
import livraria.livraria.service.EdicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edicao")
public class EdicaoController {

    @Autowired
    private EdicaoService edicaoService;
    @Autowired
    private EdicaoRepository edicaoRepository;

    @PostMapping
    public ModelAndView saveEdicao(Edicao edicao, Livro livro, Editora editora, @RequestParam("file") MultipartFile[] arquivo){

        return edicaoService.saveEdicao(edicao, livro,editora, arquivo);
    }

    @GetMapping("/{imagem}")
    @ResponseBody
    public byte[] findAllEdicao(@PathVariable String imagem, Model model){ //Model model
        model.addAttribute("edicoes",edicaoRepository.findAll());
        return edicaoService.exibirImagens(imagem);
    }

    @GetMapping("/one/{id}")
    public ModelAndView findById(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("exibirEdicao");
        Edicao edicao = edicaoRepository.findEdicaoById(id);
        modelAndView.addObject("edicao", edicao);
        return modelAndView;
    }

    @GetMapping("/one/{id}/{imagem}")
    @ResponseBody
    public byte[] findByIdImagem(@PathVariable Long id, @PathVariable String imagem){
        ModelAndView modelAndView = new ModelAndView("exibirEdicao");
        Edicao edicao = edicaoRepository.findEdicaoById(id);
        modelAndView.addObject("edicao", edicao);
//        return edicaoService.exibirImagens(edicao.getImagens().get(0));
        return edicaoService.exibirImagens(imagem);
    }
}
