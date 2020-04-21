package livraria.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livraria")
public class LivrariaController {

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/livrof")
    public String getLivroF() {
        return "livrof";
    }

    @GetMapping("/livrot")
    public String getLivroT() {
        return "livrot";
    }
}

