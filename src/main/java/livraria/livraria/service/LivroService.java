package livraria.livraria.service;

import livraria.livraria.model.Autor;
import livraria.livraria.model.Livro;
import livraria.livraria.model.LivroFiccao;
import livraria.livraria.repository.LivroFiccaoRepository;
import livraria.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class LivroService {

  private static String caminhoImagem = "/home/bruno/Documentos/imagens/";

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroFiccaoRepository livroFiccaoRepository;


    private List<String> imagens = new ArrayList<>();

    public ModelAndView saveLivro(Livro livro) {
        ModelAndView modelAndView = new ModelAndView("index");
//        livro.setAutores(Arrays.asList(autor));
        livroRepository.save(livro);
        modelAndView.addObject("livros",livroRepository.findAll());

//        livroFiccaoRepository.save(livro);
        return modelAndView;
    }

    public byte[] findAll(String imagem){

        ModelAndView modelAndView = new ModelAndView("home");
//        for(Livro livro : livroRepository.findAll()){
//            System.out.println(livro.getImagens());
            exibirImagens(imagem);
            modelAndView.addObject("livros",livroRepository.findAll());
//            }

        return exibirImagens(imagem);
    }

    public byte[] exibirImagens(@PathVariable String imagem){
        File imagemArquivo = new File(caminhoImagem+imagem);
        if (imagem != null || imagem.trim().length() >0){
            try{
//                model.addAttribute("imagens",imagemRepository.findAll());
                return Files.readAllBytes(imagemArquivo.toPath());
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return new byte[0];
    }
}
