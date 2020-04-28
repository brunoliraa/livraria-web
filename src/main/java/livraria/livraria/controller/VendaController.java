package livraria.livraria.controller;

import livraria.livraria.model.Edicao;
import livraria.livraria.model.EdicaoVendida;
import livraria.livraria.repository.EdicaoRepository;
import livraria.livraria.service.VendaService;
import livraria.livraria.soap.CalcPrecoPrazo;
import livraria.livraria.soap.CalcPrecoPrazoResponse;
import livraria.livraria.soapClient.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ws.soap.client.SoapFaultClientException;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carrinho")
public class VendaController {

    @Autowired
    private EdicaoRepository edicaoRepository;
    @Autowired
    private VendaService vendaService;


    List<Edicao> edicaoList = new ArrayList<>();


    @GetMapping
    public ModelAndView getCarrinho(){

        return vendaService.getCarrinho();
    }

    @GetMapping("/adicionar/{id}")
    public ModelAndView adicionarNoCarrinho(@PathVariable Long id){
        return vendaService.adicionarNoCarrinho(id);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removeEdicao(@PathVariable Long id){
        return vendaService.removeEdicao(id);
    }

    @GetMapping("/alterarQuantidade/{id}/{acao}")
    public ModelAndView alterarQuantidade(@PathVariable Long id, @PathVariable Integer acao){
        return vendaService.alterarQuantidade(id, acao);
    }

    @PostMapping("/frete")
    public ModelAndView calcularFrete(CalcPrecoPrazo calcPrecoPrazo){
        return vendaService.calcularFrete(calcPrecoPrazo);

    }


}
