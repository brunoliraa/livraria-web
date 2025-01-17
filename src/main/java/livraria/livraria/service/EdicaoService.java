package livraria.livraria.service;

import livraria.livraria.model.Edicao;
import livraria.livraria.model.Editora;
import livraria.livraria.model.Livro;
import livraria.livraria.repository.EdicaoRepository;
import livraria.livraria.repository.EditoraRepository;
import livraria.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EdicaoService {
    private static String caminhoImagem = "/home/bruno/Documentos/imagens/";
    @Autowired
    private EdicaoRepository edicaoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private EditoraRepository editoraRepository;

    private List<String> imagens = new ArrayList<>();

    public ModelAndView saveEdicao(Edicao edicao, Livro livro, Editora editora, @RequestParam("file") MultipartFile[] arquivo) {
        ModelAndView modelAndView = new ModelAndView("redirect:admin/livraria");
        modelAndView.addObject("edicoes",edicaoRepository.findAll());
        try {
            Livro l = livroRepository.findLivroById(livro.getId());
            edicao.setId(null);
            edicao.setLivro(l);
            Editora ed = editoraRepository.findEditoraById(editora.getId());
            edicao.setEditora(ed);
            for (MultipartFile file : arquivo) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
                String data = LocalDateTime.now().format(dateTimeFormatter);
                String newFileName = data + file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                Path caminho = Paths.get(caminhoImagem + newFileName);
                Files.write(caminho, bytes);
                imagens.add(newFileName);

            }
            edicao.setImagens(imagens);
//            arquivo = null;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        edicaoRepository.save(edicao);
        imagens.clear();


        return modelAndView;
    }

    public byte[] exibirImagens(@PathVariable String imagem){
        File imagemArquivo = new File(caminhoImagem+imagem);

        if (imagem != null || imagem.trim().length() >0){
            try{
//                falta retornar todas as imagens do livro certo

//                model.addAttribute("edicoes",edicaoRepository.findAll());
                return Files.readAllBytes(imagemArquivo.toPath());
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return new byte[0];
    }

}
